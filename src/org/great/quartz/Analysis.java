package org.great.quartz;

import java.util.List;

public class Analysis {
	/**
     * ����ָ��ƽ������Ԥ��ֵ
     * @param list �������ݼ���
     * @param year δ���ڼ���
     * @param modulus ƽ��ϵ��
     * @return Ԥ��ֵ
     */
    public static Double getExpect(List<Double> list, int year, Double modulus ) {
        if (list.size() < 10 || modulus <= 0 || modulus >= 1) {
            return null;
        }
        Double modulusLeft = 1 - modulus;
        Double lastIndex = list.get(0);
        Double lastSecIndex = list.get(0);
        for (Double data :list) {
            lastIndex = modulus * data + modulusLeft * lastIndex;
            lastSecIndex = modulus * lastIndex + modulusLeft * lastSecIndex;
        }
        Double a = 2 * lastIndex - lastSecIndex;
        Double b = (modulus / modulusLeft) * (lastIndex - lastSecIndex);
        return a + b * year;
    }
}
