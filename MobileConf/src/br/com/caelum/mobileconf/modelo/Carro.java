package br.com.caelum.mobileconf.modelo;

import java.io.IOException;
import java.io.Serializable;

import br.com.caelum.mobileconf.util.MyLog;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@DatabaseField(generatedId = true)
	private Long id;

	@DatabaseField
	private String modelo;

	@DatabaseField
	private double litrosMotor;

	@DatabaseField(dataType = DataType.ENUM_STRING)
	private Fabricante marca;

	@DatabaseField(dataType = DataType.ENUM_STRING)
	private Combustivel combustivel;

	@DatabaseField
	private Integer ano;

	public Carro() {
	}

	public Carro(String modelo, double litrosMotor, Fabricante marca,
			Combustivel combustivel, int ano) {

		this.modelo = modelo;
		this.litrosMotor = litrosMotor;
		this.marca = marca;
		this.combustivel = combustivel;
		this.ano = ano;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		
		MyLog.i("SERIALIZANDO O OBJETO!");
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		
		MyLog.i("DESSERIALIZANDO O OBJETO!");
	}

	@Override
	public String toString() {
		return modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Fabricante getMarca() {
		return marca;
	}

	public void setMarca(Fabricante marca) {
		this.marca = marca;
	}

	public double getLitrosMotor() {
		return litrosMotor;
	}

	public void setLitrosMotor(double litrosMotor) {
		this.litrosMotor = litrosMotor;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
