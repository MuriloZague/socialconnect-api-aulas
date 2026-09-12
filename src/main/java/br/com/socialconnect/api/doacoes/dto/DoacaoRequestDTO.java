package br.com.socialconnect.api.doacoes.dto;

import br.com.socialconnect.api.doacoes.model.TipoDoacao;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

// DTO de ENTRADA para POST e PUT
public record DoacaoRequestDTO(
        @NotNull(message = "Doador é obrigatório")
        Long idDoador,

        @NotNull(message = "Data da doação é obrigatória")
        LocalDate dataDoacao,

        BigDecimal valor,

        @NotNull(message = "Tipo é obrigatório")
        TipoDoacao tipo,

        String descricao
) {}
