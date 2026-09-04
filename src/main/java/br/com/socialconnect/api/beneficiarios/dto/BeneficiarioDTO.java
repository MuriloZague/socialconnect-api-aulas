package br.com.socialconnect.api.beneficiarios.dto;

import java.time.LocalDate;

// Record é imutável, conciso e ideal para DTOs no Java 21+
public record BeneficiarioDTO(
        Long idBeneficiario,
        String nome,
        String cpf,
        String telefone,
        String endereco,
        String situacaoVulnerabilidade,
        LocalDate dataCadastro
) {}
