package com.training.service;

import com.training.entity.*;
import java.util.*;

public interface IPredictRecordService {

	PredictRecordEntity PredictNewInfo(String info, int modelId);
	
}
