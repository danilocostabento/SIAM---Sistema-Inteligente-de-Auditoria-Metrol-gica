package br.com.siam.util;

public class CnpjValidator {

    public static boolean isValid(
            String cnpj
    ) {

        if (cnpj == null) {
            return false;
        }

        cnpj = cnpj.replaceAll(
                "[^0-9]",
                ""
        );

        if (cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        try {

            int firstDigit =
                    calculateDigit(
                            cnpj.substring(0, 12),
                            new int[]{
                                    5, 4, 3, 2,
                                    9, 8, 7, 6,
                                    5, 4, 3, 2
                            }
                    );

            int secondDigit =
                    calculateDigit(
                            cnpj.substring(0, 12)
                                    + firstDigit,
                            new int[]{
                                    6, 5, 4, 3, 2,
                                    9, 8, 7, 6,
                                    5, 4, 3, 2
                            }
                    );

            return cnpj.equals(
                    cnpj.substring(0, 12)
                            + firstDigit
                            + secondDigit
            );

        } catch (Exception exception) {

            return false;
        }
    }

    private static int calculateDigit(
            String value,
            int[] weights
    ) {

        int sum = 0;

        for (
                int index = 0;
                index < weights.length;
                index++
        ) {

            sum +=
                    Character.getNumericValue(
                            value.charAt(index)
                    )
                            * weights[index];
        }

        int remainder = sum % 11;

        return remainder < 2
                ? 0
                : 11 - remainder;
    }
}