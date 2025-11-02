package dynamicProgramming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsVFatorial {
    private Map<Integer, BigInteger> fatoriaisCalculados;

    private BigInteger fat(int val) {
        if (fatoriaisCalculados.get(val) != null) {
            return fatoriaisCalculados.get(val);
        }

        BigInteger result;
        if (fatoriaisCalculados.get(val - 1) != null) {
            result = fatoriaisCalculados.get(val - 1).multiply(BigInteger.valueOf(val));
        } else {
            result = BigInteger.valueOf(val).multiply(fat(val - 1));
        }

        fatoriaisCalculados.put(val, result);
        return result;
    }

    public int climbStairs(int n) {
        int jeitos = 1;
        int maximo2Passos = n / 2;
        int qtd1Passo = 0;
        int tamanhoExpressao = 0;

        inicializaMapFatoriais();

        for (int qtd2Passo = 1; qtd2Passo <= maximo2Passos; ++qtd2Passo) {
            qtd1Passo = n - (qtd2Passo * 2);
            tamanhoExpressao = qtd1Passo + qtd2Passo;

            BigInteger fatPasso1 = fat(qtd1Passo);
            BigInteger fatPasso2 = fat(qtd2Passo);
            BigInteger fatExpressao = fat(tamanhoExpressao);

            jeitos += fatExpressao.divide(fatPasso1.multiply(fatPasso2)).intValue();
        }

        return jeitos;
    }

    private void inicializaMapFatoriais() {
        if (fatoriaisCalculados == null) {
            fatoriaisCalculados = new HashMap<>();
            fatoriaisCalculados.put(0, BigInteger.ONE);
            fatoriaisCalculados.put(1, BigInteger.ONE);
        }
    }

    public static void main(String[] args) {
        ClimbingStairsVFatorial climbingStairs = new ClimbingStairsVFatorial();
        System.out.println(climbingStairs.climbStairs(2));
        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairs(4));
        System.out.println(climbingStairs.climbStairs(5));
        System.out.println(climbingStairs.climbStairs(6));
        System.out.println(climbingStairs.climbStairs(7));
        System.out.println(climbingStairs.climbStairs(8));
        System.out.println(climbingStairs.climbStairs(9));
        System.out.println(climbingStairs.climbStairs(45));
    }
}
