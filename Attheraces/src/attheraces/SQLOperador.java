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
public class SQLOperador {
    
    public static SQLOperador IGUAL = new SQLOperador(1, "Igual", "=");
    public static SQLOperador MAIOR_OU_IGUAL = new SQLOperador(2, "Maior ou Igual", ">=");
    public static SQLOperador MENOR_OU_IGUAL = new SQLOperador(3, "Menor ou Igual", "<=");
    public static SQLOperador DESCONHECIDO = new SQLOperador(-1, "Desconhecido", "");
    
    public static SQLOperador[] getArray() {
        return new SQLOperador[] {IGUAL, MAIOR_OU_IGUAL, MENOR_OU_IGUAL};
    }
    
    public static SQLOperador getByCodigo(Integer codigo) {
        for(SQLOperador p : getArray()) {
            if(p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return DESCONHECIDO;
    }
    
    private Integer codigo;
    private String descricao;
    private String condicao;

    public SQLOperador(Integer codigo, String descricao, String condicao) {
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
        final SQLOperador other = (SQLOperador) obj;
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
