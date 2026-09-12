package br.com.socialconnect.api.doacoes.dto;

import br.com.socialconnect.api.doacoes.model.TipoDoacao;

import java.math.BigDecimal;
import java.time.LocalDate;

// DTO de SAÍDA
public record DoacaoResponseDTO(
        Long idDoacao,
        Long idDoador,
        String nomeDoador,
        LocalDate dataDoacao,
        BigDecimal valor,
        TipoDoacao tipo,
        String descricao
) {}
