package dev.flettieri.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		// toList
		List<Integer> collect = list.stream()
				.filter(n -> n%2 == 0)
				.collect(Collectors.toList());
		
		System.out.println(collect);
		
		
		// joining
		String join = list.stream()
			.map(n -> n.toString())
//			.collect(Collectors.joining(", "));
			.collect(Collectors.joining());
		
		System.out.println(join);
		
		
		// averaging
		Double media = list.stream()
			.collect(Collectors.averagingInt(n -> n.intValue()));
		
		System.out.println(media);
		
		// summing
		Integer summing = list.stream()
				.collect(Collectors.summingInt(n -> n.intValue()));
		
		System.out.println(summing);

		// summarizing
		IntSummaryStatistics summarizing = list.stream()
				.collect(Collectors.summarizingInt(n -> n.intValue()));
		
		System.out.println(summarizing);
		
		System.out.println(summarizing.getAverage());
		System.out.println(summarizing.getCount());
		System.out.println(summarizing.getMax());
		System.out.println(summarizing.getMin());
		System.out.println(summarizing.getSum());
		
		// counting
		Long count = list.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.counting());
		
		System.out.println(count);
		
		// max
		list.stream()
				.filter(n -> n%2 == 0)
				.collect(Collectors.maxBy(Comparator.naturalOrder()))
				.ifPresent(System.out::println);
		
		// min
		list.stream()
		.filter(n -> n%2 == 0)
		.collect(Collectors.minBy(Comparator.naturalOrder()))
		.ifPresent(System.out::println);
		
		
		// groupingBy
		Map<Integer, List<Integer>> groupingBy = list.stream()
			.collect(Collectors.groupingBy(n -> n % 3));
		
		System.out.println(groupingBy);
		
		
		// partitioningBy
		Map<Boolean, List<Integer>> partitioningBy = list.stream()
				.collect(Collectors.partitioningBy(n -> n % 2 == 0));
		
		System.out.println(partitioningBy);
		
		
		// toMap
		Map<Integer, Double> toMap = list.stream()
				.collect(Collectors.toMap(
						n -> n, 
						n -> Math.pow(n.doubleValue(), 5)));
		
		System.out.println(toMap);
		
		
		
		
	}

}
