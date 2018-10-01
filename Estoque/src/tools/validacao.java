/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
/**
 *
 * @author nmp
 */
public class validacao {
    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) 
    {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) 
        {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    
    public static boolean validarEmail(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) 
        {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) 
            {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public static boolean validarCPF(String cpf) 
    {
        if ((cpf == null) || (cpf.length() != 11)) 
        {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCNPJ(String cnpj) 
    {
        if ((cnpj == null) || (cnpj.length() != 14)) 
        {
            return false;
        }
        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarData(int d, int m, int a) 
    {
        boolean correto = true;
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (a < 0 || m < 1 || m > 12) 
        {
            correto = false;
        } else 
        {
            // valida o ano bissexto
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) 
            {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarTelefone(JFormattedTextField campo) 
    {
        if (campo.getText().trim().length() < 13) {
            return false;
        }
        else
        {
            return true;
        }
    }
}