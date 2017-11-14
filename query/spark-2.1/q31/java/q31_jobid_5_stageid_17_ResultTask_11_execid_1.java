/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean sort_needToSort;
/* 009 */   private org.apache.spark.sql.execution.SortExec sort_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeExternalRowSorter sort_sorter;
/* 011 */   private org.apache.spark.executor.TaskMetrics sort_metrics;
/* 012 */   private scala.collection.Iterator<UnsafeRow> sort_sortedIter;
/* 013 */   private scala.collection.Iterator smj_leftInput;
/* 014 */   private scala.collection.Iterator smj_rightInput;
/* 015 */   private InternalRow smj_leftRow;
/* 016 */   private InternalRow smj_rightRow;
/* 017 */   private UTF8String smj_value2;
/* 018 */   private java.util.ArrayList smj_matches;
/* 019 */   private UTF8String smj_value3;
/* 020 */   private UTF8String smj_value4;
/* 021 */   private boolean smj_isNull2;
/* 022 */   private int smj_value5;
/* 023 */   private boolean smj_isNull3;
/* 024 */   private double smj_value6;
/* 025 */   private boolean smj_isNull4;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 027 */   private UnsafeRow smj_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     sort_needToSort = true;
/* 042 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 043 */     sort_sorter = sort_plan.createSorter();
/* 044 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 045 */
/* 046 */     smj_leftInput = inputs[0];
/* 047 */     smj_rightInput = inputs[1];
/* 048 */
/* 049 */     smj_rightRow = null;
/* 050 */
/* 051 */     smj_matches = new java.util.ArrayList();
/* 052 */
/* 053 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 054 */     smj_result = new UnsafeRow(5);
/* 055 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 056 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 057 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 059 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private boolean findNextInnerJoinRows(
/* 064 */     scala.collection.Iterator leftIter,
/* 065 */     scala.collection.Iterator rightIter) {
/* 066 */     smj_leftRow = null;
/* 067 */     int comp = 0;
/* 068 */     while (smj_leftRow == null) {
/* 069 */       if (!leftIter.hasNext()) return false;
/* 070 */       smj_leftRow = (InternalRow) leftIter.next();
/* 071 */
/* 072 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 073 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 074 */       if (smj_isNull) {
/* 075 */         smj_leftRow = null;
/* 076 */         continue;
/* 077 */       }
/* 078 */       if (!smj_matches.isEmpty()) {
/* 079 */         comp = 0;
/* 080 */         if (comp == 0) {
/* 081 */           comp = smj_value.compare(smj_value3);
/* 082 */         }
/* 083 */
/* 084 */         if (comp == 0) {
/* 085 */           return true;
/* 086 */         }
/* 087 */         smj_matches.clear();
/* 088 */       }
/* 089 */
/* 090 */       do {
/* 091 */         if (smj_rightRow == null) {
/* 092 */           if (!rightIter.hasNext()) {
/* 093 */             smj_value3 = smj_value.clone();
/* 094 */             return !smj_matches.isEmpty();
/* 095 */           }
/* 096 */           smj_rightRow = (InternalRow) rightIter.next();
/* 097 */
/* 098 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 099 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 100 */           if (smj_isNull1) {
/* 101 */             smj_rightRow = null;
/* 102 */             continue;
/* 103 */           }
/* 104 */           smj_value2 = smj_value1.clone();
/* 105 */         }
/* 106 */
/* 107 */         comp = 0;
/* 108 */         if (comp == 0) {
/* 109 */           comp = smj_value.compare(smj_value2);
/* 110 */         }
/* 111 */
/* 112 */         if (comp > 0) {
/* 113 */           smj_rightRow = null;
/* 114 */         } else if (comp < 0) {
/* 115 */           if (!smj_matches.isEmpty()) {
/* 116 */             smj_value3 = smj_value.clone();
/* 117 */             return true;
/* 118 */           }
/* 119 */           smj_leftRow = null;
/* 120 */         } else {
/* 121 */           smj_matches.add(smj_rightRow.copy());
/* 122 */           smj_rightRow = null;;
/* 123 */         }
/* 124 */       } while (smj_leftRow != null);
/* 125 */     }
/* 126 */     return false; // unreachable
/* 127 */   }
/* 128 */
/* 129 */   private void sort_addToSorter() throws java.io.IOException {
/* 130 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 131 */       int smj_size = smj_matches.size();
/* 132 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 133 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 134 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 135 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 136 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 137 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 138 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 139 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 140 */
/* 141 */         smj_numOutputRows.add(1);
/* 142 */
/* 143 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(0);
/* 144 */         UTF8String smj_value7 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(0));
/* 145 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(1);
/* 146 */         double smj_value8 = smj_isNull6 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 147 */         smj_holder.reset();
/* 148 */
/* 149 */         smj_rowWriter.zeroOutNullBytes();
/* 150 */
/* 151 */         if (smj_isNull2) {
/* 152 */           smj_rowWriter.setNullAt(0);
/* 153 */         } else {
/* 154 */           smj_rowWriter.write(0, smj_value4);
/* 155 */         }
/* 156 */
/* 157 */         if (smj_isNull3) {
/* 158 */           smj_rowWriter.setNullAt(1);
/* 159 */         } else {
/* 160 */           smj_rowWriter.write(1, smj_value5);
/* 161 */         }
/* 162 */
/* 163 */         if (smj_isNull4) {
/* 164 */           smj_rowWriter.setNullAt(2);
/* 165 */         } else {
/* 166 */           smj_rowWriter.write(2, smj_value6);
/* 167 */         }
/* 168 */
/* 169 */         if (smj_isNull5) {
/* 170 */           smj_rowWriter.setNullAt(3);
/* 171 */         } else {
/* 172 */           smj_rowWriter.write(3, smj_value7);
/* 173 */         }
/* 174 */
/* 175 */         if (smj_isNull6) {
/* 176 */           smj_rowWriter.setNullAt(4);
/* 177 */         } else {
/* 178 */           smj_rowWriter.write(4, smj_value8);
/* 179 */         }
/* 180 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 181 */         sort_sorter.insertRow((UnsafeRow)smj_result);
/* 182 */
/* 183 */       }
/* 184 */       if (shouldStop()) return;
/* 185 */     }
/* 186 */
/* 187 */   }
/* 188 */
/* 189 */   protected void processNext() throws java.io.IOException {
/* 190 */     if (sort_needToSort) {
/* 191 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 192 */       sort_addToSorter();
/* 193 */       sort_sortedIter = sort_sorter.sort();
/* 194 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 195 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 196 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 197 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 198 */       sort_needToSort = false;
/* 199 */     }
/* 200 */
/* 201 */     while (sort_sortedIter.hasNext()) {
/* 202 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 203 */
/* 204 */       append(sort_outputRow);
/* 205 */
/* 206 */       if (shouldStop()) return;
/* 207 */     }
/* 208 */   }
/* 209 */ }
