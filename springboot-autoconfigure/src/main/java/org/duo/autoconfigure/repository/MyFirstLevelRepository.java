package org.duo.autoconfigure.repository;

import org.duo.autoconfigure.annotation.FirstLevelRepository;
import org.springframework.stereotype.Component;

@FirstLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {

}
