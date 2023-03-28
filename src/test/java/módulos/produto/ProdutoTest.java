package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do módulo de produto")
public class ProdutoTest {
    private String Token;

    @BeforeEach
    public void beforeEach() {
        //Configurando dados da API Rest da Lojinha
            baseURI = "http://165.227.93.41";
            basePath = "/lojinha-bugada";

            //Obter o Token do usuário Admin

            this.Token = given()
                    .contentType(ContentType.JSON)
                    .body(UsuarioDataFactory.criarUsuarioAdministrador())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");
        }

        @Test
        @DisplayName("Validar limite, valor negativo do produto")
        public void testValidarLimiteValorNegativoProibidoValorProduto() {
            //Tentar inserir produto com valor 0.00 e validar que a mensagem de erro
            // foi apresentada e o status code retornado foi 422.

       given()
           .contentType(ContentType.JSON)
           .header("token",this.Token)
           .body(ProdutoDataFactory.criarProdutoComumComumValorIgualA(0.00))
       .when()
           .post("/v2/produtos")

       .then()
           .assertThat()
               .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
               .statusCode(422);

        }

    @Test
    @DisplayName("Validar o limite acima de sete mil no valor do produto")
    public void TestValidarLimiteValorMaiorQueSeteMilProibidoValorProduto(){
        given()
                .contentType(ContentType.JSON)
                .header("token", this.Token)
                .body(ProdutoDataFactory.criarProdutoComumComumValorIgualA(7000.01))
        .when()
            .post("/v2/produtos")

        .then()
            .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);

    }
}
















