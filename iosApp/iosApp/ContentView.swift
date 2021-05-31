import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()
    let employee : Array<Employee> = EmployeeUseCase().getEmployeeListSortedByRole()
    var body: some View {
        Text((employee[0].name ?? "").isEmpty ? "" : employee[0].name!)

    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}