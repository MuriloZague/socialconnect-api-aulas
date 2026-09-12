package br.com.socialconnect.api.doacoes.controller;

import br.com.socialconnect.api.doacoes.dto.DoacaoPatchDTO;
import br.com.socialconnect.api.doacoes.dto.DoacaoRequestDTO;
import br.com.socialconnect.api.doacoes.dto.DoacaoResponseDTO;
import br.com.socialconnect.api.doacoes.model.TipoDoacao;
import br.com.socialconnect.api.doacoes.service.DoacaoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/doacoes")
public class DoacaoController {

    private final DoacaoService doacaoService;

    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    // GET /api/v1/doacoes?dataInicio=2026-01-01&dataFim=2026-09-11&tipo=ALIMENTO
    @GetMapping
    public ResponseEntity<Page<DoacaoResponseDTO>> listar(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
            @RequestParam(required = false) TipoDoacao tipo,
            @PageableDefault(size = 20, sort = "dataDoacao") Pageable pageable) {
        return ResponseEntity.ok(doacaoService.listar(dataInicio, dataFim, tipo, pageable));
    }

    @GetMapping("/{idDoacao}")
    public ResponseEntity<DoacaoResponseDTO> buscarPorId(@PathVariable Long idDoacao) {
        return ResponseEntity.ok(doacaoService.buscarPorId(idDoacao));
    }

    @PostMapping
    public ResponseEntity<DoacaoResponseDTO> criar(@Valid @RequestBody DoacaoRequestDTO dto) {
        DoacaoResponseDTO salva = doacaoService.criar(dto);
        URI location = URI.create("/api/v1/doacoes/" + salva.idDoacao());
        return ResponseEntity.created(location).body(salva);
    }

    @PutMapping("/{idDoacao}")
    public ResponseEntity<DoacaoResponseDTO> atualizar(
            @PathVariable Long idDoacao,
            @Valid @RequestBody DoacaoRequestDTO dto) {
        return ResponseEntity.ok(doacaoService.atualizar(idDoacao, dto));
    }

    @PatchMapping("/{idDoacao}")
    public ResponseEntity<DoacaoResponseDTO> atualizarParcial(
            @PathVariable Long idDoacao,
            @RequestBody DoacaoPatchDTO dto) {
        return ResponseEntity.ok(doacaoService.atualizarParcial(idDoacao, dto));
    }

    @DeleteMapping("/{idDoacao}")
    public ResponseEntity<Void> deletar(@PathVariable Long idDoacao) {
        doacaoService.deletar(idDoacao);
        return ResponseEntity.noContent().build();
    }
}
