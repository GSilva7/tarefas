package model.javabean;

import java.io.Serializable;
import java.sql.Time;

public class Empresa implements Serializable
{
	private int cnpj;
	private String razaosocial;
	private Time horarioAbertura, horarioFechamento;
       
	public int getCnpj() 
	{
		return cnpj;
	}

	public void setCnpj(int cnpj) 
	{
		this.cnpj = cnpj;
	}

	public String getRazaosocial() 
	{
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) 
	{
		this.razaosocial = razaosocial;
	}
	public void setHorarioAbertura(Time ha)
	{
		horarioAbertura = ha;
	}
	public Time getHorarioAbertura()
	{
		return horarioAbertura;
	}

	public Time getHorarioFechamento() 
	{
		return horarioFechamento;
	}

	public void setHorarioFechamento(Time horarioFechamento) 
	{
		this.horarioFechamento = horarioFechamento;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + cnpj;
		result = prime * result + ((horarioAbertura == null) ? 0 : horarioAbertura.hashCode());
		result = prime * result + ((horarioFechamento == null) ? 0 : horarioFechamento.hashCode());
		result = prime * result + ((razaosocial == null) ? 0 : razaosocial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj != other.cnpj)
			return false;
		if (horarioAbertura == null) 
		{
			if (other.horarioAbertura != null)
				return false;
		} else if (!horarioAbertura.equals(other.horarioAbertura))
			return false;
		if (horarioFechamento == null) 
		{
			if (other.horarioFechamento != null)
				return false;
		} else if (!horarioFechamento.equals(other.horarioFechamento))
			return false;
		if (razaosocial == null) 
		{
			if (other.razaosocial != null)
				return false;
		} else if (!razaosocial.equals(other.razaosocial))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Empresa [cnpj=" + cnpj + ", razaosocial=" + razaosocial + ", horarioAbertura=" + horarioAbertura
				+ ", horarioFechamento=" + horarioFechamento + "]";
	}
	
   
}
