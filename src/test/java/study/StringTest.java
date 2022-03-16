package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc"); //pass

        /*************** if fail? ***************
            assertThat(actual).isEqualTo("adcc");
            ------------------------------------
            org.opentest4j.AssertionFailedError:
            expected: "adcc"
            but was : "adc"
            Expected :"adcc"
            Actual   :"adc"
        ****************************************/
    }

    @DisplayName("quest1-1 : contains() 활용한 assertion")
    @Test
    void splitComma(){
        String[] splitComma = "1,2".split(",");
        assertThat(splitComma).contains("1","2"); // return ObjectArrayAssert<ELEMENT>

        /******************* if fail? *********************
            assertThat(splitComma).contains("1","2","3");
            ---------------------------------------------
            java.lang.AssertionError:
            Expecting String[]:
              ["1", "2"]
            to contain:
              ["1", "2", "3"]
            but could not find the following string(s):
              ["3"]
        ***************************************************/

    }

    @DisplayName("quest1-2 : containsExactly()활용한 assertion")
    @Test
    void returnContain1(){
        String[] arr = "1".split(",");
        assertThat(arr).containsExactly("1"); // return ObjectArrayAssert<ELEMENT>

        /******************* if fail? *********************
          assertThat(arr).containsExactly("A");
         ----------------------------------------
          java.lang.AssertionError:
          Expecting:
            ["1"]
          to contain exactly (and in same order):
            ["A"]
          but some elements were not found:
            ["A"]
          and others were not expected:
            ["1"]
         *************************************************/
    }


    @DisplayName("quest2: substring()활용")
    @Test
    void substring(){
        String sub = "(1,2)".substring(1,4);
        System.out.println(sub);
    }


    @DisplayName("quest3-1: charAt() 활용")
    @Test
    void charat(){
        String abc = "abc";
        System.out.println(abc.charAt(0));
    }

    @DisplayName("Exception1 - 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    @Test
    void exception1(){
        assertThatThrownBy(() -> {
            // TODO 예외가 발생할 상황에 대한 코드
            throw new Exception("위치값을 벗어났다");
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("Index: 2, Size: 2");

    }

    @DisplayName("Exception에 대해 메서드를 호출")
    @Test
    public void exciption2(){
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    // TODO 예외가 발생할 상황에 대한 코드
                    throw new Exception("위치값을 벗어났다");
                }).withMessageMatching("Index: , Size: ");
    }
}
