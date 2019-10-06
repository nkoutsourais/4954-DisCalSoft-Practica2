## Diseño y calidad del Software 
### Practica 2
* Fecha de entrega: 07/10/2019
* Integrantes:
  * Neo Koutsourais

   
## Diagrama MasterMind

<p align="center">
  <img alt="" src="https://plantuml-server.kkeisuke.app/svg/lLVRZjCm47tFL_WnPSb-G5HLkrg9VTd2YgB26tAJeLXAx2XsMr3fl-Dx7CUzQ8LugUIPuvap7izn-i05xiMkRRAiQZ3dQ8cvWBubj4R73A42DMnBgl95_Uhrdi2XNCiVkRf3NOD_vxDopqYTdR9WyxkYPWTQB93PcVBe81cXql43Lw3NEkaTqaPSYVo9KT6pfe7U9z6m-_i56doElBHmri1DWPHtJpWH-KeTGUn70U2rPntZyCJQ3Q5O44OleJy3txKmHLZcyp-c_f1i5XBtvxE2gWSHP3qFjGphcy2AO7DRt6VS6eBsW9EKx54VUY9W0XWkXmtXGjhhLVbpAeD-gdWE6BPkIFGe1BITu7dGJktuGaG34wkf-NLqMosXCsTtbT-PVMcwEJPyItaX0suzu5eIIeGQ-2NRTPLTSbUQMqCJx6HweBiMBO5pl0MRhpMhSYLwGhVQP07vs6N2Rq4uzypjaO7JjqYDj4LdvteIOjBd4YByLGkDWrJOax2bII4KYhtyrUkjt5og2BgI0PuhstkaWRxArBMVs1muKPownY-4Ytd2jt3xJC4UQfRUQmP2UMKJZVRnhuHIoNXMRfWSRMmO7F662wM99uIh2hfG6zTAmTYWjS4fUTsAv3A9kQIOoGsnQBeswTVZXWw5ey3B9Uxc6hV6pKusQuZhZojew2oSdLDcKWug79KRkIzM6c4dHKP-NSiqlImtU2KdpRBo-v_VClSWZFDPBf5rEZ9NBfw2w0-JSsATf6-JNuAyYGckwyHOvWbRp3O-FiimDh-9LQ-3v1GEQhURyDHhQyVdgEQ7L2UqVFps_UNJnsSh57AmOgLAQbU1keHmNPIjGhEKcfLKhDj5ivAbzU6RJlW7GWd_2NKaRaaX_FUQ6zv_0Q4-QSKf1_7HWIZy4lcuTp0oo4mQhVVfjzBlbwcc8-zrqtswkGis_Ywsy302AfpGH3Qhgrds0BIMVmZ-0W00.svg">
</p>

### PlantUML
 
 ```PlantUML
@startuml

class Mastermind {
  - logic:Logic
  - view:View
  + play():void
}
Mastermind *-down-> Logic
Mastermind *-down-> View

interface View {
  + interact(Controller):void
}
View ..> Controller

class ConsoleView {
  + interact(Controller):void
  + visit(StartController):void 
  + visit(ProposeCombinationController):void 
  + visit(ResumeController):void 
}
View <|-down- ConsoleView
ConsoleView *-down-> SecretCombinationView
ConsoleView *-down-> ProposedCombinationView
ConsoleView *-down-> ResultCombinationView
ConsoleView *-down-> GameView

class SecretCombinationView {
  + writeSecretCombination():void
}

class GameView {
  - controller:Controller
  + GameView(Controller)
  + writeAttempts():void
  + writeTitle():void
  + writeResultPlay():void
}

class ProposedCombinationView {
  - controller:Controller
  + ProposedCombinationView(Controller)
  + write(attempt:int):void
  + read():ProposedCombination
}

class ResultCombinationView {
  - controller:Controller
  + ResultCombinationView(Controller)
  + writeln(attempt:int):void
}

enum Message {
  - message:String
  - Message(message:String)
  + getMessage():String
}

SecretCombinationView ..> Message
ProposedCombinationView ..> Message
ResultCombinationView ..> Message
GameView ..> Message

class Controller {
  - state:State
  - game:Game
  + Controller(Game, State)
  + getSecretCombination():SecretCombination
  + getProposedCombinations():List<ProposedCombination>
  + getResults():List<Result>
  + getAttemps():int
  + isWinner():boolean
  + {abstract} accept(ControllerVisitor):void
}
Controller <|-down- StartController
Controller <|-down- ProposeCombinationController
Controller <|-down- ResumeController

class Logic {
  - state:State
  - game:Game
  - controllers:Map<StateValue, Controller>
  + getController():Controller
}
Logic *-down-> StartController
Logic *-down-> ProposeCombinationController
Logic *-down-> ResumeController
Logic *-down-> Game
Logic *-down-> State

interface ControllerVisitor {
  + visit(StartController):void 
  + visit(ProposeCombinationController):void 
  + visit(ResumeController):void 
}

class StartController {
  + StartController(Game, State)
  + accept(ControllerVisitor):void
  + start():void
}

class ProposeCombinationController {
  + ProposeCombinationController(Game, State)
  + accept(ControllerVisitor):void
  + addProposedCombination(ProposedCombination):void
}

class ResumeController {
  + ResumeController(Game, State)
  + accept(ControllerVisitor):void
  + resume(newGame:boolean):void
}

class Game {
  - {static} MAX_LONG:int
  - secretCombination:SecretCombination
  - proposedCombinations:List<ProposedCombination>
  - results:List<Result>
  + getSecretCombination():SecretCombination
  + clear():void
  + isFinished():boolean
  + getAttemps():int
  + getProposedCombinations():List<ProposedCombination>
  + getResults():List<Result>
}

class State {
  - stateValue:StateValue
  + next():void
  + reset():void
  + getValueState():StateValue
}

ControllerVisitor <|-down- View
Controller ..> ControllerVisitor

Controller --> Game
Controller --> State
 

@enduml

```