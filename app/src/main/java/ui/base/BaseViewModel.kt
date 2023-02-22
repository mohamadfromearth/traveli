package ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import main.ApplicationClass

abstract class BaseViewModel<E : BaseEvent, A : BaseAction>(
    val app: ApplicationClass,
) : ViewModel(), BaseAction {
    val action: A = this as A
    protected var _event = Channel<E>()
    val event = _event.receiveAsFlow()
    var isFirstStart = true

}


open class BaseEvent
interface BaseAction


