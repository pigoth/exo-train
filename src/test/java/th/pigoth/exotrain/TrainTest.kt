package th.pigoth.exotrain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class TrainTest {

  @Test
  internal fun should_print_passenger_train() {
    assertThat(Train("HPP").print()).isEqualTo("<HHHH::|OOOO|::|OOOO|")
  }

  @Test
  internal fun should_print_restaurant_train() {
    assertThat(Train("HPRP").print()).isEqualTo("<HHHH::|OOOO|::|hThT|::|OOOO|")
  }

  @Test
  internal fun should_print_double_locomotive_train() {
    assertThat(Train("HPRPH").print()).isEqualTo("<HHHH::|OOOO|::|hThT|::|OOOO|::HHHH>")
  }

  @Test
  internal fun should_detach_back_locomotive() {
    assertThat(Train("HPRPH").detachEnd().print()).isEqualTo("<HHHH::|OOOO|::|hThT|::|OOOO|")
  }

  @Test
  internal fun should_detach_head_locomotive() {
    assertThat(Train("HPRP").detachHead().print()).isEqualTo("|OOOO|::|hThT|::|OOOO|")
  }

  @Test
  internal fun should_print_cargo_train() {
    assertThat(Train("HCC").print()).isEqualTo("<HHHH::|____|::|____|")
  }

  @Test
  internal fun should_fill_first_empty_cargo_in_train() {
    assertThat(Train("HCC").fill().print()).isEqualTo("<HHHH::|^^^^|::|____|")
  }

  @Test
  internal fun should_fill_all_cargo_cars() {
    assertThat(Train("HCC").fill().fill().print()).isEqualTo("<HHHH::|^^^^|::|^^^^|")
  }

  @Test
  internal fun should_get_an_error_when_not_available_empty_cargo_car() {
    assertThatThrownBy{ Train("H").fill() }.isInstanceOf(IllegalStateException::class.java)
  }
}
