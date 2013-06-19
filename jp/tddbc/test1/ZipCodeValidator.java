package jp.tddbc.test1;

public class ZipCodeValidator {

	public boolean validate(String zipCode) {

		try{
			String[] codes = zipCode.split("-");
			switch(codes.length){
			case 1:
				return _validate(codes[0]);
			case 2:
				String code = codes[0]+codes[1];
				return _validate(code);
			default:
				return false;

			}
		}catch(NumberFormatException nfe){
			return false;
		}


	}

	private boolean _validate(String zipCode){
		if(Integer.parseInt(zipCode)==0){
			return false;
		}
		return (zipCode.length()==3 || zipCode.length()==7);
	}


}
