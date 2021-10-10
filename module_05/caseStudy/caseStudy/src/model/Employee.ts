import {Level} from "./Level";
import {Location} from "./Location";
import {Part} from "./Part";

export interface Employee {
  id: number;
  name: string;
  level: Level;
  location: Location;
  part: Part;
  dateOfBirth: string;
  idCard: number;
  salary: number;
  phone: string;
  email: string;
  address: string


}
