package br.senai.sp.teste.mapper;

import java.util.ArrayList;
import java.util.List;

import br.senai.sp.teste.DTO.FornecedorDTO;
import br.senai.sp.teste.model.Fornecedor;

public class FornecedorMapper {

	public static FornecedorDTO toDTO(Fornecedor f) {
		return new FornecedorDTO(f.getId(), f.getNome(), f.getContato());
	}

	public static Fornecedor toEntity(FornecedorDTO dto) {
		return new Fornecedor(dto.getId(), dto.getNome(), dto.getContato());
	}

	public static List<FornecedorDTO> toListDTO(List<Fornecedor> lista) {

		List<FornecedorDTO> listaDTO = new ArrayList<>();
		for (Fornecedor fornecedor : lista) {
			listaDTO.add(toDTO(fornecedor));
		}
		return listaDTO;
	}
}