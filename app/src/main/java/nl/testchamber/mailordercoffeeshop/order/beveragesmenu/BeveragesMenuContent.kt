package nl.testchamber.mailordercoffeeshop.order.beveragesmenu

import nl.testchamber.mailordercoffeeshop.data.beverage.BeverageMenuItem
import nl.testchamber.mailordercoffeeshop.data.beverage.Ingredient
import java.util.*

/**
 * Helper class for providing sample data for the RecyclerView
 *
 */
object BeveragesMenuContent {

    val ESPRESSO_SHOT = Ingredient("1 shot of espresso", 30)
    val TWO_ESPRESSO_SHOTS = Ingredient("2 shots of espresso", 60)
    val CONCENTRATED_ESPRESSO_SHOT = Ingredient("1 concentrated shot of espresso", 22)
    val WATERY_ESPRESSO_SHOT = Ingredient("1 shot of less concentrated espresso", 90)
    val DOT_OF_FOAMED_MILK = Ingredient("Dot of foamed milk", 5)
    val HEAVY_CREAM = Ingredient("Heavy cream", 30)
    val HOT_MILK = Ingredient("Hot milk", 30)
    val HOT_MILK_60 = Ingredient("Hot milk", 60)
    val FOAMED_MILK = Ingredient("Foamed milk", 30)
    val FOAMED_MILK_60 = Ingredient("Foamed milk", 60)
    val STEAMED_MILK = Ingredient("Steamed milk", 30)
    val STEAMED_MILK_120 = Ingredient("Steamed milk", 120)
    val STEAMED_MILK_150 = Ingredient("Steamed milk", 150)
    val STEAMED_MILK_300 = Ingredient("Steamed milk", 120)
    val MILK_FOAM = Ingredient("Milk foam", 120)
    val HOT_WATER = Ingredient("Hot water", 90)
    val ICE_CUBES = Ingredient("Ice cubes", 60)
    val HALF_AND_HALF_90 = Ingredient("Half & half", 90)
    val HALF_AND_HALF_60 = Ingredient("Half & half", 60)
    val CHOCOLATE = Ingredient("Chocolate", 60)
    val VANILLA_ICE_CREAM = Ingredient("Vanilla ice cream", 90)
    val WHIPPED_CREAM = Ingredient("Whipped cream", 60)
    val WHIPPED_CREAM_90 = Ingredient("Whipped cream", 90)
    val BREWED_COFFEE = Ingredient("Brewed coffee", 120)
    val BREWED_COFFEE_180 = Ingredient("Brewed coffee", 180)
    val FRENCH_PRESSED_COFFEE = Ingredient("French pressed coffee", 150)
    val SCALDED_MILK = Ingredient("Scalded milk", 180)
    val MILK_FOAM_2 = Ingredient("Milk foam", 2)


    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<BeverageMenuItem> = ArrayList()

    init {
        val beverageList = listOf(
                BeverageMenuItem("Espresso", 30, listOf(ESPRESSO_SHOT), ""),
                BeverageMenuItem("Espresso Doppio", 60, listOf(TWO_ESPRESSO_SHOTS), ""),
                BeverageMenuItem("Ristretto", 22, listOf(CONCENTRATED_ESPRESSO_SHOT), ""),
                BeverageMenuItem("Lungo", 90, listOf(WATERY_ESPRESSO_SHOT), ""),
                BeverageMenuItem("Café Macchiato", 60, listOf(TWO_ESPRESSO_SHOTS, DOT_OF_FOAMED_MILK), ""),
                BeverageMenuItem("Café Creme", 90, listOf(TWO_ESPRESSO_SHOTS, HEAVY_CREAM), ""),
                BeverageMenuItem("Café Noisette", 90, listOf(TWO_ESPRESSO_SHOTS, HOT_MILK), ""),
                BeverageMenuItem("Café Cortado", 90, listOf(TWO_ESPRESSO_SHOTS, FOAMED_MILK), ""),
                BeverageMenuItem("Cappuccino", 180, listOf(TWO_ESPRESSO_SHOTS, STEAMED_MILK, FOAMED_MILK_60), ""),
                BeverageMenuItem("Dry Cappuccino", 180, listOf(TWO_ESPRESSO_SHOTS, MILK_FOAM), ""),
                BeverageMenuItem("Café Americano", 150, listOf(TWO_ESPRESSO_SHOTS, HOT_WATER), ""),
                BeverageMenuItem("Café con Hielo", 60, listOf(TWO_ESPRESSO_SHOTS, ICE_CUBES), ""),
                BeverageMenuItem("Breve", 150, listOf(TWO_ESPRESSO_SHOTS, HALF_AND_HALF_90), ""),
                BeverageMenuItem("Mocha Breve", 150, listOf(TWO_ESPRESSO_SHOTS, CHOCOLATE, HALF_AND_HALF_60), ""),
                BeverageMenuItem("Mocha", 150, listOf(TWO_ESPRESSO_SHOTS, CHOCOLATE, STEAMED_MILK), ""),
                BeverageMenuItem("Café  Affogato", 150, listOf(TWO_ESPRESSO_SHOTS, VANILLA_ICE_CREAM), ""),
                BeverageMenuItem("Viennois", 180, listOf(TWO_ESPRESSO_SHOTS, HOT_MILK_60, WHIPPED_CREAM), ""),
                BeverageMenuItem("Con Panna", 150, listOf(TWO_ESPRESSO_SHOTS, WHIPPED_CREAM_90), ""),
                BeverageMenuItem("Flat White", 180, listOf(TWO_ESPRESSO_SHOTS, STEAMED_MILK_120), ""),
                BeverageMenuItem("Black Eye", 180, listOf(TWO_ESPRESSO_SHOTS, BREWED_COFFEE), ""),
                BeverageMenuItem("Café  Latte", 362, listOf(TWO_ESPRESSO_SHOTS, STEAMED_MILK_300, MILK_FOAM_2), ""),
                BeverageMenuItem("Café  au Lait", 300, listOf(FRENCH_PRESSED_COFFEE, STEAMED_MILK_150), ""),
                BeverageMenuItem("Café con Leche", 360, listOf(BREWED_COFFEE_180, SCALDED_MILK), "")
        )
        ITEMS.addAll(beverageList)
    }
}
