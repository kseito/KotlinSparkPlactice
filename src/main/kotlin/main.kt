import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get
import todolist.Task

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    get("/tasks", {request, response ->
        listOf(
                Task(1, "晩御飯の材料を買う", false),
                Task(2, "住民票を取得する", true),
                Task(3, "コーヒー豆を買う", true)
        )
    }, objectMapper::writeValueAsString)
}