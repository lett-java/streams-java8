package dev.flettieri.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Java8_Streams_Reduce {
	public static void main(String[] args) {

		String s = "Inscreva-se no canal e compartilhe esse video";
		String[] split = s.split(" ");
		
		List<String> listStr = Arrays.asList(split);
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		

		// Soma
		Optional<Integer> soma = list.stream()
			.reduce((n1, n2) -> n1 + n2);
		
		System.out.println(soma.get());

		
		// Multiplicação
		Optional<Integer> multiplicacao = list.stream()
				.reduce((n1, n2) -> n1 * n2);
		
		System.out.println(multiplicacao.get());
		
		
		// Concatenação
		Optional<String> concatenacao = listStr.stream()
				.reduce((s1, s2) -> s1.concat(s2));
		
		System.out.println(concatenacao.get());
		
		
		// Menor valor
		OptionalDouble menorValor = DoubleStream.of(1.5, 2.9, 6.7)
			.reduce((d1, d2) -> Math.min(d1, d2));
		System.out.println(menorValor.getAsDouble());
		
		
		// Soma
		Integer soma1 = list.stream()
				.reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
		
		System.out.println(soma1);
		
		// Soma
		String soma2 = list.stream()
				.reduce(
						"", 
						(n1, n2) -> n1.toString().concat(n2.toString()),
						(n1, n2) -> n1.concat(n2));
		
		System.out.println(soma2);
				
	}

}
