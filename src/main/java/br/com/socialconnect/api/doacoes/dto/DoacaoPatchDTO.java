package br.com.socialconnect.api.doacoes.dto;

import br.com.socialconnect.api.doacoes.model.TipoDoacao;

import java.math.BigDecimal;
import java.time.LocalDate;

// DTO para PATCH: todos os campos opcionais
public record DoacaoPatchDTO(
        LocalDate dataDoacao,
        BigDecimal valor,
        TipoDoacao tipo,
        String descricao
) {}
