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
public class SQLColuna {
    
    public static SQLColuna ODDFAV = new SQLColuna(1, "OddFav", "oddfav");
    public static SQLColuna ODDFAV2 = new SQLColuna(2, "OddFav2", "oddfav2");
    public static SQLColuna NUMERO_CAVALOS = new SQLColuna(3, "Número de Cavalos", "numeroCavalos");
    public static SQLColuna DESCONHECIDO = new SQLColuna(-1, "Desconhecido", "");
    
    public static SQLColuna[] getArray() {
        return new SQLColuna[] {ODDFAV, ODDFAV2, NUMERO_CAVALOS};
    }
    
    public static SQLColuna getByCodigo(Integer codigo) {
        for(SQLColuna p : getArray()) {
            if(p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return DESCONHECIDO;
    }
    
    private Integer codigo;
    private String descricao;
    private String condicao;

    public SQLColuna(Integer codigo, String descricao, String condicao) {
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

    public String getNomeColuna() {
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
        final SQLColuna other = (SQLColuna) obj;
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
