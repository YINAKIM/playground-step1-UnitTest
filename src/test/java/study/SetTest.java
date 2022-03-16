package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항1. set의 크기를 확인하는 테스트")
    @Test
    void sizeTest(){
        int size = numbers.size();
        System.out.println("size : "+size);
    }


    @DisplayName("요구사항2. 1,2,3의 값이 존재하는지 확인 - 1차")
    @Test
    void containTest(){

        assertThat(numbers.contains(1)).isTrue(); // 1 이라는 값이 존재하는지 확인
        assertThat(numbers.contains(2)).isTrue(); // 2 라는 값이 존재하는지 확인
        assertThat(numbers.contains(3)).isTrue(); // 3 이라는 값이 존재하는지 확인

        assertThat(numbers.contains(30)).isFalse(); // 30 이라는 값이 존재하지 않는지 확인
    }

    @DisplayName("요구사항2. 1,2,3의 값이 존재하는지 - @ParameterizedTest, @ValueSource활용")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(ints ={1,2,3}) // pass
    //@ValueSource(ints ={4,5}) // AssertionFailError발생, expected: <true> but was: <false>
    void isParamContained(int num){
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("요구사항3. 값의 존재여부에 따라 테스트 - @CsvSource활용 ")
    @ParameterizedTest(name = "{index}...value:{0} / expected:{1}")
    @CsvSource(value = {"1/true","2/true","3/true","4/false","5/false"},delimiterString = "/")
    void isParamContained_TrueFalse(int num, Boolean expected){
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }



}
