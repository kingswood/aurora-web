package com.volvo.aurora.service;

import java.util.*;

import com.volvo.aurora.entity.*;

public interface IPredictRecordService {

	PredictRecordEntity PredictNewInfo(String info, int modelId);
	
}
