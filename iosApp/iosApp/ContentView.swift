import SwiftUI
import shared

struct ContentView: View {
    let employee : Array<Employee> = EmployeeUseCase().getEmployeeListSortedByRole()
    var body: some View {
        Spacer()
        ForEach(employee.indices) { index in
            VStack{
                Spacer()
                HStack{
                    Text((employee[index].name ?? "").isEmpty ? "" : employee[index].name!)
                    Spacer()
                    Text(employee[index].role)
                    Spacer()
                }
                Spacer()
            }
            
        }
        Spacer()
    
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
