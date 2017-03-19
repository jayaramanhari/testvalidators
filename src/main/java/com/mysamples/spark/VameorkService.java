package com.mysamples.spark;

import java.util.List;

public interface VameorkService {
   public boolean isUploadedFileValidByQuickCheck(String fileId);
   public List<String> getResultantList();
}
