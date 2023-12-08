package service;

import corbaConversion.IConversionRemotePOA;

public class ConversionImpl extends IConversionRemotePOA{
    //l'objet distant va être de type conversion
    @Override
    public double conversionMontant(double mt) {
        // TODO Auto-generated method stub
        return mt*3.3;
    }

}
