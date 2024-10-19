package com.wen.professor;

/*
 *@author: Wendell Valim Mendes
 * @ra: 1110482413005
 */
public class ProfessorTitular extends Professor {
    private int anosInstituicao;
    private double salario;

    public ProfessorTitular(String nome, String matricula, int idade, int anosInstituicao, double salario) {
        super(nome, matricula, idade);
        this.anosInstituicao = anosInstituicao;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }
    @Override
    public double calcSalario() {
        int tmp = anosInstituicao / 5;
        return salario * (1 + (tmp * 0.05));
    }
}