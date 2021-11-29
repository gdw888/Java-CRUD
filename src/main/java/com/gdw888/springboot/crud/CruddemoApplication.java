package com.gdw888.springboot.crud;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.davidmoten.bigsorter.Serializer;
import com.github.davidmoten.bigsorter.Sorter;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		
		System.out.println("hello world");
		
		String srcFilePath = "/Users/terrylee/java_test/data/first.csv"; 
		String trgFilePath = "/Users/terrylee/java_test/data/first_sort.csv";
		File inputFile = new File(srcFilePath);
		File outputFile = new File(trgFilePath);

		Serializer<CSVRecord> serializer = Serializer.csv(CSVFormat.DEFAULT.withFirstRecordAsHeader().withRecordSeparator("\n"),
														  StandardCharsets.UTF_8);

		Comparator<CSVRecord> comparator = (x, y) -> {
				    int a = Integer.parseInt(x.get("ID"));
				    int b = Integer.parseInt(y.get("ID"));

				    return Integer.compare(a, b);
					};


		Sorter.serializer(serializer)
			  .comparator(comparator) 
			  .input(inputFile) 
			  .output(outputFile)
			  .sort();
		
		//SpringApplication.run(CruddemoApplication.class, args);
	}

}
