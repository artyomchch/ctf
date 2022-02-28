package kozlov.artyom.ctf.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import kozlov.artyom.ctf.data.database.ValueItemsDBModel
import kozlov.artyom.ctf.data.network.pojo.CurrencyDTO
import kozlov.artyom.ctf.domain.entity.ValueItem
import java.math.RoundingMode
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class ValueListMapper @Inject constructor() {

    private fun mapAMDToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.AMD.ID,
            currency = currency.Valute.AMD.CharCode,
            name = currency.Valute.AMD.Name,
            nominal = currency.Valute.AMD.Nominal,
            value = convertNumber(currency.Valute.AMD.Value),
            percent = convertNumber(currency.Valute.AMD.Value, currency.Valute.AMD.Previous)
        )


    private fun mapAUDToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.AUD.ID,
            currency = currency.Valute.AUD.CharCode,
            name = currency.Valute.AUD.Name,
            nominal = currency.Valute.AUD.Nominal,
            value = convertNumber(currency.Valute.AUD.Value),
            percent = convertNumber(currency.Valute.AUD.Value, currency.Valute.AUD.Previous)
        )


    private fun mapAZNToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.AZN.ID,
            currency = currency.Valute.AZN.CharCode,
            name = currency.Valute.AZN.Name,
            nominal = currency.Valute.AZN.Nominal,
            value = convertNumber(currency.Valute.AZN.Value),
            percent = convertNumber(currency.Valute.AZN.Value, currency.Valute.AZN.Previous)
        )


    private fun mapBGNToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.BGN.ID,
            currency = currency.Valute.BGN.CharCode,
            name = currency.Valute.BGN.Name,
            nominal = currency.Valute.BGN.Nominal,
            value = convertNumber(currency.Valute.BGN.Value),
            percent = convertNumber(currency.Valute.BGN.Value, currency.Valute.BGN.Previous)
        )


    private fun mapBRLToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.BRL.ID,
            currency = currency.Valute.BRL.CharCode,
            name = currency.Valute.BRL.Name,
            nominal = currency.Valute.BRL.Nominal,
            value = convertNumber(currency.Valute.BRL.Value),
            percent = convertNumber(currency.Valute.BRL.Value, currency.Valute.BRL.Previous)
        )


    private fun mapBYNToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.BYN.ID,
            currency = currency.Valute.BYN.CharCode,
            name = currency.Valute.BYN.Name,
            nominal = currency.Valute.BYN.Nominal,
            value = convertNumber(currency.Valute.BYN.Value),
            percent = convertNumber(currency.Valute.BYN.Value, currency.Valute.BYN.Previous)
        )


    private fun mapCADToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.CAD.ID,
            currency = currency.Valute.CAD.CharCode,
            name = currency.Valute.CAD.Name,
            nominal = currency.Valute.CAD.Nominal,
            value = convertNumber(currency.Valute.CAD.Value),
            percent = convertNumber(currency.Valute.CAD.Value, currency.Valute.CAD.Previous)
        )


    private fun mapCHFToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.CHF.ID,
            currency = currency.Valute.CHF.CharCode,
            name = currency.Valute.CHF.Name,
            nominal = currency.Valute.CHF.Nominal,
            value = convertNumber(currency.Valute.CHF.Value),
            percent = convertNumber(currency.Valute.CHF.Value, currency.Valute.CHF.Previous)
        )


    private fun mapCNYToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.CNY.ID,
            currency = currency.Valute.CNY.CharCode,
            name = currency.Valute.CNY.Name,
            nominal = currency.Valute.CNY.Nominal,
            value = convertNumber(currency.Valute.CNY.Value),
            percent = convertNumber(currency.Valute.CNY.Value, currency.Valute.CNY.Previous)
        )


    private fun mapCZKToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.CZK.ID,
            currency = currency.Valute.CZK.CharCode,
            name = currency.Valute.CZK.Name,
            nominal = currency.Valute.CZK.Nominal,
            value = convertNumber(currency.Valute.CZK.Value),
            percent = convertNumber(currency.Valute.CZK.Value, currency.Valute.CZK.Previous)
        )


    private fun mapDKKToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.DKK.ID,
            currency = currency.Valute.DKK.CharCode,
            name = currency.Valute.DKK.Name,
            nominal = currency.Valute.DKK.Nominal,
            value = convertNumber(currency.Valute.DKK.Value),
            percent = convertNumber(currency.Valute.DKK.Value, currency.Valute.DKK.Previous)
        )


    private fun mapEURToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.EUR.ID,
            currency = currency.Valute.EUR.CharCode,
            name = currency.Valute.EUR.Name,
            nominal = currency.Valute.EUR.Nominal,
            value = convertNumber(currency.Valute.EUR.Value),
            percent = convertNumber(currency.Valute.EUR.Value, currency.Valute.EUR.Previous)
        )


    private fun mapGBPToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.GBP.ID,
            currency = currency.Valute.GBP.CharCode,
            name = currency.Valute.GBP.Name,
            nominal = currency.Valute.GBP.Nominal,
            value = convertNumber(currency.Valute.GBP.Value),
            percent = convertNumber(currency.Valute.GBP.Value, currency.Valute.GBP.Previous)
        )


    private fun mapHKDToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.HKD.ID,
            currency = currency.Valute.HKD.CharCode,
            name = currency.Valute.HKD.Name,
            nominal = currency.Valute.HKD.Nominal,
            value = convertNumber(currency.Valute.HKD.Value),
            percent = convertNumber(currency.Valute.HKD.Value, currency.Valute.HKD.Previous)
        )


    private fun mapHUFToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.HUF.ID,
            currency = currency.Valute.HUF.CharCode,
            name = currency.Valute.HUF.Name,
            nominal = currency.Valute.HUF.Nominal,
            value = convertNumber(currency.Valute.HUF.Value),
            percent = convertNumber(currency.Valute.HUF.Value, currency.Valute.HUF.Previous)
        )


    private fun mapINRToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.INR.ID,
            currency = currency.Valute.INR.CharCode,
            name = currency.Valute.INR.Name,
            nominal = currency.Valute.INR.Nominal,
            value = convertNumber(currency.Valute.INR.Value),
            percent = convertNumber(currency.Valute.INR.Value, currency.Valute.INR.Previous)
        )


    private fun mapJPYToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.JPY.ID,
            currency = currency.Valute.JPY.CharCode,
            name = currency.Valute.JPY.Name,
            nominal = currency.Valute.JPY.Nominal,
            value = convertNumber(currency.Valute.JPY.Value),
            percent = convertNumber(currency.Valute.JPY.Value, currency.Valute.JPY.Previous)
        )


    private fun mapKGSToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.KGS.ID,
            currency = currency.Valute.KGS.CharCode,
            name = currency.Valute.KGS.Name,
            nominal = currency.Valute.KGS.Nominal,
            value = convertNumber(currency.Valute.KGS.Value),
            percent = convertNumber(currency.Valute.KGS.Value, currency.Valute.KGS.Previous)
        )


    private fun mapKRWToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.KRW.ID,
            currency = currency.Valute.KRW.CharCode,
            name = currency.Valute.KRW.Name,
            nominal = currency.Valute.KRW.Nominal,
            value = convertNumber(currency.Valute.KRW.Value),
            percent = convertNumber(currency.Valute.KRW.Value, currency.Valute.KRW.Previous)
        )


    private fun mapKZTToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.KZT.ID,
            currency = currency.Valute.KZT.CharCode,
            name = currency.Valute.KZT.Name,
            nominal = currency.Valute.KZT.Nominal,
            value = convertNumber(currency.Valute.KZT.Value),
            percent = convertNumber(currency.Valute.KZT.Value, currency.Valute.KZT.Previous)
        )


    private fun mapMDLToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.MDL.ID,
            currency = currency.Valute.MDL.CharCode,
            name = currency.Valute.MDL.Name,
            nominal = currency.Valute.MDL.Nominal,
            value = convertNumber(currency.Valute.MDL.Value),
            percent = convertNumber(currency.Valute.MDL.Value, currency.Valute.MDL.Previous)
        )


    private fun mapNOKToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.NOK.ID,
            currency = currency.Valute.NOK.CharCode,
            name = currency.Valute.NOK.Name,
            nominal = currency.Valute.NOK.Nominal,
            value = convertNumber(currency.Valute.NOK.Value),
            percent = convertNumber(currency.Valute.NOK.Value, currency.Valute.NOK.Previous)
        )


    private fun mapPLNToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.PLN.ID,
            currency = currency.Valute.PLN.CharCode,
            name = currency.Valute.PLN.Name,
            nominal = currency.Valute.PLN.Nominal,
            value = convertNumber(currency.Valute.PLN.Value),
            percent = convertNumber(currency.Valute.PLN.Value, currency.Valute.PLN.Previous)
        )


    private fun mapRONToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.RON.ID,
            currency = currency.Valute.RON.CharCode,
            name = currency.Valute.RON.Name,
            nominal = currency.Valute.RON.Nominal,
            value = convertNumber(currency.Valute.RON.Value),
            percent = convertNumber(currency.Valute.RON.Value, currency.Valute.RON.Previous)
        )


    private fun mapSEKToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.SEK.ID,
            currency = currency.Valute.SEK.CharCode,
            name = currency.Valute.SEK.Name,
            nominal = currency.Valute.SEK.Nominal,
            value = convertNumber(currency.Valute.SEK.Value),
            percent = convertNumber(currency.Valute.SEK.Value, currency.Valute.SEK.Previous)
        )


    private fun mapSGDToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.SGD.ID,
            currency = currency.Valute.SGD.CharCode,
            name = currency.Valute.SGD.Name,
            nominal = currency.Valute.SGD.Nominal,
            value = convertNumber(currency.Valute.SGD.Value),
            percent = convertNumber(currency.Valute.SGD.Value, currency.Valute.SGD.Previous)
        )


    private fun mapTJSToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.TJS.ID,
            currency = currency.Valute.TJS.CharCode,
            name = currency.Valute.TJS.Name,
            nominal = currency.Valute.TJS.Nominal,
            value = convertNumber(currency.Valute.TJS.Value),
            percent = convertNumber(currency.Valute.TJS.Value, currency.Valute.TJS.Previous)
        )


    private fun mapTMTToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.TMT.ID,
            currency = currency.Valute.TMT.CharCode,
            name = currency.Valute.TMT.Name,
            nominal = currency.Valute.TMT.Nominal,
            value = convertNumber(currency.Valute.TMT.Value),
            percent = convertNumber(currency.Valute.TMT.Value, currency.Valute.TMT.Previous)
        )


    private fun mapTRYToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.TRY.ID,
            currency = currency.Valute.TRY.CharCode,
            name = currency.Valute.TRY.Name,
            nominal = currency.Valute.TRY.Nominal,
            value = convertNumber(currency.Valute.TRY.Value),
            percent = convertNumber(currency.Valute.TRY.Value, currency.Valute.TRY.Previous)
        )


    private fun mapUAHToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.UAH.ID,
            currency = currency.Valute.UAH.CharCode,
            name = currency.Valute.UAH.Name,
            nominal = currency.Valute.UAH.Nominal,
            value = convertNumber(currency.Valute.UAH.Value),
            percent = convertNumber(currency.Valute.UAH.Value, currency.Valute.UAH.Previous)
        )


    private fun mapUSDToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.USD.ID,
            currency = currency.Valute.USD.CharCode,
            name = currency.Valute.USD.Name,
            nominal = currency.Valute.USD.Nominal,
            value = convertNumber(currency.Valute.USD.Value),
            percent = convertNumber(currency.Valute.USD.Value, currency.Valute.USD.Previous)
        )


    private fun mapUZSToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.UZS.ID,
            currency = currency.Valute.UZS.CharCode,
            name = currency.Valute.UZS.Name,
            nominal = currency.Valute.UZS.Nominal,
            value = convertNumber(currency.Valute.UZS.Value),
            percent = convertNumber(currency.Valute.UZS.Value, currency.Valute.UZS.Previous)
        )


    private fun mapXDRToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.XDR.ID,
            currency = currency.Valute.XDR.CharCode,
            name = currency.Valute.XDR.Name,
            nominal = currency.Valute.XDR.Nominal,
            value = convertNumber(currency.Valute.XDR.Value),
            percent = convertNumber(currency.Valute.XDR.Value, currency.Valute.XDR.Previous)
        )


    private fun mapZARToEntityValue(currency: CurrencyDTO) =
        ValueItem(
            id = currency.Valute.ZAR.ID,
            currency = currency.Valute.ZAR.CharCode,
            name = currency.Valute.ZAR.Name,
            nominal = currency.Valute.ZAR.Nominal,
            value = convertNumber(currency.Valute.ZAR.Value),
            percent = convertNumber(currency.Valute.ZAR.Value, currency.Valute.ZAR.Previous)
        )


    @RequiresApi(Build.VERSION_CODES.O)
    fun mapListNetworkModelToListEntityNews(dto: CurrencyDTO): Pair<List<ValueItem>, String> = listOf(
        mapAMDToEntityValue(dto),
        mapAUDToEntityValue(dto),
        mapAZNToEntityValue(dto),
        mapBGNToEntityValue(dto),
        mapBRLToEntityValue(dto),
        mapBYNToEntityValue(dto),
        mapCADToEntityValue(dto),
        mapCHFToEntityValue(dto),
        mapCNYToEntityValue(dto),
        mapCZKToEntityValue(dto),
        mapDKKToEntityValue(dto),
        mapEURToEntityValue(dto),
        mapGBPToEntityValue(dto),
        mapHKDToEntityValue(dto),
        mapHUFToEntityValue(dto),
        mapINRToEntityValue(dto),
        mapJPYToEntityValue(dto),
        mapKGSToEntityValue(dto),
        mapKRWToEntityValue(dto),
        mapKZTToEntityValue(dto),
        mapMDLToEntityValue(dto),
        mapNOKToEntityValue(dto),
        mapPLNToEntityValue(dto),
        mapRONToEntityValue(dto),
        mapSEKToEntityValue(dto),
        mapSGDToEntityValue(dto),
        mapTJSToEntityValue(dto),
        mapTMTToEntityValue(dto),
        mapTRYToEntityValue(dto),
        mapUAHToEntityValue(dto),
        mapUSDToEntityValue(dto),
        mapUZSToEntityValue(dto),
        mapXDRToEntityValue(dto),
        mapZARToEntityValue(dto)
    ) to convertTime(dto.Timestamp)

    private fun convertNumber(d: Double) = roundOfDecimal(d)

    private fun convertNumber(d: Double, percent: Double) = roundOfDecimal(d - percent)

    private fun roundOfDecimal(number: Double) = number.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()

    private fun mapEntityToDbModel(valueItem: ValueItem) = ValueItemsDBModel(
        id = valueItem.id,
        currency= valueItem.currency,
        name = valueItem.name,
        nominal = valueItem.nominal,
        value = valueItem.value,
        percent = valueItem.percent
    )


    fun mapListEntityToListDbModel(list: List<ValueItem>) = list.map {
        mapEntityToDbModel(it)
    }

    private fun mapDbModelToEntity(valueItemDbModel: ValueItemsDBModel) = ValueItem(
        id = valueItemDbModel.id,
        currency= valueItemDbModel.currency,
        name = valueItemDbModel.name,
        nominal = valueItemDbModel.nominal,
        value = valueItemDbModel.value,
        percent = valueItemDbModel.percent
    )

    fun mapListDbModelToListEntity(list: List<ValueItemsDBModel>) = list.map {
        mapDbModelToEntity(it)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    private fun convertTime(s: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH)
        val date = LocalDateTime.parse(s.dropLast(DROP_GMT_SYMBOLS), inputFormatter)
        return outputFormatter.format(date)
    }

    companion object {
        private const val DROP_GMT_SYMBOLS = 6
    }


}