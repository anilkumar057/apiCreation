package com.payGlocal.apiCreation.controller;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payGlocal.apiCreation.entity.Data;

@RestController
public class MyController {
	
	@GetMapping("/bankDetails")
	public List<Data> getData() throws FileNotFoundException {
		List<Data> list = new ArrayList<>();
		Scanner sc=new Scanner(new FileReader("src\\main\\resources\\bin-file-assignment.csv"));
			while(sc.hasNext()) {
				String input[] = sc.nextLine().split(";", -1);
				
				Data data=new Data();
				
				data.BINRANGE=input[0];
				data.CARDBRAND=input[1];
				data.CARDISSUER=input[2];
				data.CARDTYPE=input[3];
				data.CARDSUBTYPE=input[4];
				data.COUNTRY=input[5];
				data.COUNTRYCODE=input[6];
				data.ISO=input[7];
				data.CURRENCYCODE=input[8];
				data.URL=input[9];
				data.CONTACT=input[10];
				
				list.add(data);
			}
			
		return list;
	}
	
	@GetMapping("/bankDetails/{BinRange}")
	public Data getPerticularData(@PathVariable String BinRange) throws FileNotFoundException {
		Scanner sc=new Scanner(new FileReader("src\\main\\resources\\bin-file-assignment.csv"));
		Data data=new Data();
		while(sc.hasNext()) {
			String input[]= sc.nextLine().split(";", -1);
			
			if(BinRange.equals(input[0])) {
				
				data.BINRANGE=input[0];
				data.CARDBRAND=input[1];
				data.CARDISSUER=input[2];
				data.CARDTYPE=input[3];
				data.CARDSUBTYPE=input[4];
				data.COUNTRY=input[5];
				data.COUNTRYCODE=input[6];
				data.ISO=input[7];
				data.CURRENCYCODE=input[8];
				data.URL=input[9];
				data.CONTACT=input[10];
				break;
			}
		}
		return data;
	}

}
