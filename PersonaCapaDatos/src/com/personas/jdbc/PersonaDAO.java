package com.personas.jdbc;

import java.util.List;

import com.personas.dto.PersonaDTO;

public interface PersonaDAO {
	public int Insert(PersonaDTO persona);

	public int Update(PersonaDTO persona);

	public int Delete(PersonaDTO persona);

	public List<PersonaDTO> Select();
}
