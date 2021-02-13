package br.com.ccvn.api.security.jwt;

public class JwtConfig {

    public static final String CHAVE_SECRETA = "qualuqer_tipo_de_coisa.123456789";

    public static final String RSA_PRIVADO = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAzsI9F3i5764IKT1F9KiAPnkNGnHXWScOZz375bdPDSLedIWA\n" +
            "krOR3Fn2DVtDfXNuxwkyXEVZctTuFkGN212u5lNlgVAuxrcrGlslTUTHsazBhURB\n" +
            "Q2/uhXd0pudaOuppi5FS0KS66laqfj+/Q3oRQx6fF8x9y9rX/jUSOzcflYN35vZC\n" +
            "JyKDFkR0QnHmxEYAImdJoh2ZnKBQJaY+GcRVUyjCQrjhz4F3rqtUtADS1wO6VWPc\n" +
            "PxD1eqe9W8TegSco5uDs+cWoG5vJWHyq+RkV7p3bviz8sHQMc/Rk73CHkOrOt3Y1\n" +
            "uZWxWJVPo0/leE4zqIqn0YIumcZzpKqTBGkF5wIDAQABAoIBAQCktGkUPJDqFNnd\n" +
            "eDk1F9Hpcmb0zQE+vPUlW2RB74/iqAdMDVmKA9BLF8MBitUtp3n0xie/B2OlLWho\n" +
            "hFosCOoeAwtWQviwRhPpD/icIBFwQW176w6OWSlKWwmrN5tSWZAwpViyareXm+h/\n" +
            "X+rOJvx/WnJj8/u2HCR6Fe7rCxN29vAYAFMp8cjNMfdbAjs3xRv3G/HrSNAm+wfn\n" +
            "HVD+nWdPrNhPqM0zZn5NIvtRVLDTYaF3FnCnNRGTEPVpmoWHcolhP0V+yZbClvbh\n" +
            "qkcrr1L9n9HPz470rOTbqdpfDTRvCNj3YMh5AgaZD5YMFgNoWMmwzAbrIdZRxtLe\n" +
            "l4godNzpAoGBAO3+64CjxzixldxX8FdmgCj+MTLgntoNIJM9npkr10DD6Q7Aso2/\n" +
            "UelMabedm+rw1QhCdpaXKOL862nwbjSxwnm1R3RB1Pe2sZotPikXcYcv4mwzReaB\n" +
            "J5x9alDBaHpMgNyoWSqWVEBlqpE6AZ4crDziju8ucpKd0lZUsvTQ5k3NAoGBAN5m\n" +
            "YA1u/gz7MqS9LLt2x4OI5D0TdZnbrMIPLcTVECfjlZeLnFGt2fEJDyigYBR6HtfY\n" +
            "8BaHjyMyaNSlFonybIprCp4UE96PcJViqJJ0pqMnZkdFgDYPx31QDOGL0GYjXMyR\n" +
            "+xZMmtmFj9TRO0Fjd7R1rxwFfwVURpbTTBkBhg6DAoGAF65KzpT9SLXa3H7fikLH\n" +
            "s8x/JrnU9Itj12LFOiZzl50mvnIMEjCcPON+jWegUQM/nz/FvvwxdEyIPBVRUery\n" +
            "F9wizP2T7EYAa//edIZBpJruI6gCZ4ooX9jW0Ew+UhT0qYASxzsIDRRQoXytFodx\n" +
            "1+kPIdt0SQRtHmv1FokGsW0CgYEApT8eCX056P1QkNU7AoNsFRDGvZbS36I4x+wt\n" +
            "Tr4dBfZ09Sg32vy5Hf5kNASNv0lJ14mKQsMwmK9g8vdDOvZUrbiBKBm09b5Qob6v\n" +
            "kDp6gmnI9hXvALxStoqfN4sCKpIF5r5k+RmsSQmTaEaap6g3jm+Oz9xJl/UZigGv\n" +
            "3jiime8CgYAzVSIF6ECP2Uq8DkMVfFSF/fv074LFdR7dCtx6pRNxFOIaWXFNmwjX\n" +
            "7nqx1a43USnYzY8JvzHaxWxfjWF+NHe/cl5MfAbEXyE6KsyzNDHiDTE/58GNkuuK\n" +
            "eOk9Dd8lpW692b8CuqJ1Vm+MBo8ueaU+1ZaWrfKdq6SsDKkQrYhirg==\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICO = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzsI9F3i5764IKT1F9KiA\n" +
            "PnkNGnHXWScOZz375bdPDSLedIWAkrOR3Fn2DVtDfXNuxwkyXEVZctTuFkGN212u\n" +
            "5lNlgVAuxrcrGlslTUTHsazBhURBQ2/uhXd0pudaOuppi5FS0KS66laqfj+/Q3oR\n" +
            "Qx6fF8x9y9rX/jUSOzcflYN35vZCJyKDFkR0QnHmxEYAImdJoh2ZnKBQJaY+GcRV\n" +
            "UyjCQrjhz4F3rqtUtADS1wO6VWPcPxD1eqe9W8TegSco5uDs+cWoG5vJWHyq+RkV\n" +
            "7p3bviz8sHQMc/Rk73CHkOrOt3Y1uZWxWJVPo0/leE4zqIqn0YIumcZzpKqTBGkF\n" +
            "5wIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
