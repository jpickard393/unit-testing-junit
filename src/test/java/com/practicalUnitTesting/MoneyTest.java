package com.practicalUnitTesting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

// Test that the constructor works
public class MoneyTest
{
    @Test
    void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10,"USD");

        assertThat(money.getAmount()).isEqualTo(10);
        assertThat(money.getCurrency()).isEqualTo("USD");
    }

    // Parameterized tests help us to perform the same test on multiple values
    // This stops us breaking the DRY principal

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 50})
    void constructorShouldSetAmountAndCurrency(int amount) {
        Money money = new Money(amount,"USD");
        assertThat(money.getAmount()).isEqualTo(amount);
    }

    // CSV parameters can allow us to pass in many values as an object
    @ParameterizedTest
    @CsvSource({
            "10, USD",
            "15,EUR",
            "20, GBP"
    })
    void constructorShouldSetAmountAndCurrency(int amount, String currency){
        Money money = new Money(amount,currency);
        assertThat(money.getAmount()).isEqualTo((amount));
        assertThat(money.getCurrency()).isEqualTo((currency));
    }

}
