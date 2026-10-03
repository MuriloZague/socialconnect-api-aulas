package br.com.socialconnect.api.produtos.service;

import br.com.socialconnect.api.exception.EstoqueNegativoException;
import br.com.socialconnect.api.exception.NomeProdutoDuplicadoException;
import br.com.socialconnect.api.exception.RecursoNaoEncontradoException;
import br.com.socialconnect.api.produtos.dto.ProdutoRequestDTO;
import br.com.socialconnect.api.produtos.dto.ProdutoResponseDTO;
import br.com.socialconnect.api.produtos.model.CategoriaProduto;
import br.com.socialconnect.api.produtos.model.Produto;
import br.com.socialconnect.api.produtos.repository.ProdutoRepository;
import br.com.socialconnect.api.produtos.repository.ProdutoSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProdutoResponseDTO> listar(String nome, CategoriaProduto categoria, Pageable pageable) {
        return repository
                .findAll(ProdutoSpecifications.filtrar(nome, categoria), pageable)
                .map(this::toResponseDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscarPorId(Long id) {
        return toResponseDTO(buscarEntidade(id));
    }

    @Override
    @Transactional
    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        validarEstoque(dto.estoqueAtual());
        String nome = dto.nome().trim();
        if (repository.existsByNomeIgnoreCase(nome)) {
            throw new NomeProdutoDuplicadoException(nome);
        }
        Produto produto = Produto.builder()
                .nome(nome)
                .categoria(dto.categoria())
                .estoqueAtual(dto.estoqueAtual())
                .estoqueMinimo(dto.estoqueMinimo())
                .unidadeMedida(dto.unidadeMedida())
                .dataCadastro(LocalDate.now())
                .build();
        return toResponseDTO(repository.save(produto));
    }

    @Override
    @Transactional
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = buscarEntidade(id);
        validarEstoque(dto.estoqueAtual());
        String nome = dto.nome().trim();
        if (repository.existsByNomeIgnoreCaseAndIdProdutoNot(nome, id)) {
            throw new NomeProdutoDuplicadoException(nome);
        }
        produto.setNome(nome);
        produto.setCategoria(dto.categoria());
        produto.setEstoqueAtual(dto.estoqueAtual());
        produto.setEstoqueMinimo(dto.estoqueMinimo());
        produto.setUnidadeMedida(dto.unidadeMedida());
        return toResponseDTO(repository.save(produto));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto não encontrado: " + id);
        }
        repository.deleteById(id);
    }

    private Produto buscarEntidade(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado: " + id));
    }

    private void validarEstoque(Integer estoqueAtual) {
        if (estoqueAtual != null && estoqueAtual < 0) {
            throw new EstoqueNegativoException(estoqueAtual);
        }
    }

    private ProdutoResponseDTO toResponseDTO(Produto p) {
        return new ProdutoResponseDTO(
                p.getIdProduto(), p.getNome(), p.getCategoria(),
                p.getEstoqueAtual(), p.getEstoqueMinimo(), p.getUnidadeMedida(),
                p.getDataCadastro(),
                p.getEstoqueAtual() < p.getEstoqueMinimo()
        );
    }
}
