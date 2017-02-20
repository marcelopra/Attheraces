/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attheraces;

import java.util.Objects;

/**
 *
 * @author Marcelo
 */
public class SQLOrderBy {
    
    public static SQLOrderBy HORARIO = new SQLOrderBy(1, "Horário", "HORA");
    public static SQLOrderBy DIA = new SQLOrderBy(2, "Dia", "DATA");
    public static SQLOrderBy PISTA = new SQLOrderBy(3, "Pista", "PISTA");
    public static SQLOrderBy DIA_HORARIO = new SQLOrderBy(4, "Dia + Horario", "DATA, HORA");
    public static SQLOrderBy DIA_PISA_HORARIO = new SQLOrderBy(5, "Dia + Pista + Horario", "DATA, PISTA, HORA");
    public static SQLOrderBy DESCONHECIDO = new SQLOrderBy(-1, "Desconhecido", "");
    
    public static SQLOrderBy[] getArray() {
        return new SQLOrderBy[] {HORARIO, DIA, PISTA, DIA_HORARIO, DIA_PISA_HORARIO};
    }
    
    public static SQLOrderBy getByCodigo(Integer codigo) {
        for(SQLOrderBy p : getArray()) {
            if(p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return DESCONHECIDO;
    }
    
    private Integer codigo;
    private String descricao;
    private String condicao;

    public SQLOrderBy(Integer codigo, String descricao, String condicao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.condicao = condicao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOperador() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SQLOrderBy other = (SQLOrderBy) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
}
