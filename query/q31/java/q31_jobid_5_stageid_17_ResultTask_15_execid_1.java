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
/* 026 */   private double smj_value7;
/* 027 */   private boolean smj_isNull5;
/* 028 */   private double smj_value8;
/* 029 */   private boolean smj_isNull6;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 031 */   private UnsafeRow smj_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 037 */
/* 038 */   public GeneratedIterator(Object[] references) {
/* 039 */     this.references = references;
/* 040 */   }
/* 041 */
/* 042 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 043 */     partitionIndex = index;
/* 044 */     this.inputs = inputs;
/* 045 */     sort_needToSort = true;
/* 046 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 047 */     sort_sorter = sort_plan.createSorter();
/* 048 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 049 */
/* 050 */     smj_leftInput = inputs[0];
/* 051 */     smj_rightInput = inputs[1];
/* 052 */
/* 053 */     smj_rightRow = null;
/* 054 */
/* 055 */     smj_matches = new java.util.ArrayList();
/* 056 */
/* 057 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 058 */     smj_result = new UnsafeRow(7);
/* 059 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 060 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
/* 061 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 062 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 063 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private boolean findNextInnerJoinRows(
/* 068 */     scala.collection.Iterator leftIter,
/* 069 */     scala.collection.Iterator rightIter) {
/* 070 */     smj_leftRow = null;
/* 071 */     int comp = 0;
/* 072 */     while (smj_leftRow == null) {
/* 073 */       if (!leftIter.hasNext()) return false;
/* 074 */       smj_leftRow = (InternalRow) leftIter.next();
/* 075 */
/* 076 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 077 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 078 */       if (smj_isNull) {
/* 079 */         smj_leftRow = null;
/* 080 */         continue;
/* 081 */       }
/* 082 */       if (!smj_matches.isEmpty()) {
/* 083 */         comp = 0;
/* 084 */         if (comp == 0) {
/* 085 */           comp = smj_value.compare(smj_value3);
/* 086 */         }
/* 087 */
/* 088 */         if (comp == 0) {
/* 089 */           return true;
/* 090 */         }
/* 091 */         smj_matches.clear();
/* 092 */       }
/* 093 */
/* 094 */       do {
/* 095 */         if (smj_rightRow == null) {
/* 096 */           if (!rightIter.hasNext()) {
/* 097 */             smj_value3 = smj_value.clone();
/* 098 */             return !smj_matches.isEmpty();
/* 099 */           }
/* 100 */           smj_rightRow = (InternalRow) rightIter.next();
/* 101 */
/* 102 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 103 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 104 */           if (smj_isNull1) {
/* 105 */             smj_rightRow = null;
/* 106 */             continue;
/* 107 */           }
/* 108 */           smj_value2 = smj_value1.clone();
/* 109 */         }
/* 110 */
/* 111 */         comp = 0;
/* 112 */         if (comp == 0) {
/* 113 */           comp = smj_value.compare(smj_value2);
/* 114 */         }
/* 115 */
/* 116 */         if (comp > 0) {
/* 117 */           smj_rightRow = null;
/* 118 */         } else if (comp < 0) {
/* 119 */           if (!smj_matches.isEmpty()) {
/* 120 */             smj_value3 = smj_value.clone();
/* 121 */             return true;
/* 122 */           }
/* 123 */           smj_leftRow = null;
/* 124 */         } else {
/* 125 */           smj_matches.add(smj_rightRow.copy());
/* 126 */           smj_rightRow = null;;
/* 127 */         }
/* 128 */       } while (smj_leftRow != null);
/* 129 */     }
/* 130 */     return false; // unreachable
/* 131 */   }
/* 132 */
/* 133 */   private void sort_addToSorter() throws java.io.IOException {
/* 134 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 135 */       int smj_size = smj_matches.size();
/* 136 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 137 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 138 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 139 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 140 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 141 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 142 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 143 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 144 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 145 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 146 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 147 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 148 */
/* 149 */         smj_numOutputRows.add(1);
/* 150 */
/* 151 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(0);
/* 152 */         UTF8String smj_value9 = smj_isNull7 ? null : (smj_rightRow1.getUTF8String(0));
/* 153 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(1);
/* 154 */         double smj_value10 = smj_isNull8 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 155 */         smj_holder.reset();
/* 156 */
/* 157 */         smj_rowWriter.zeroOutNullBytes();
/* 158 */
/* 159 */         if (smj_isNull2) {
/* 160 */           smj_rowWriter.setNullAt(0);
/* 161 */         } else {
/* 162 */           smj_rowWriter.write(0, smj_value4);
/* 163 */         }
/* 164 */
/* 165 */         if (smj_isNull3) {
/* 166 */           smj_rowWriter.setNullAt(1);
/* 167 */         } else {
/* 168 */           smj_rowWriter.write(1, smj_value5);
/* 169 */         }
/* 170 */
/* 171 */         if (smj_isNull4) {
/* 172 */           smj_rowWriter.setNullAt(2);
/* 173 */         } else {
/* 174 */           smj_rowWriter.write(2, smj_value6);
/* 175 */         }
/* 176 */
/* 177 */         if (smj_isNull5) {
/* 178 */           smj_rowWriter.setNullAt(3);
/* 179 */         } else {
/* 180 */           smj_rowWriter.write(3, smj_value7);
/* 181 */         }
/* 182 */
/* 183 */         if (smj_isNull6) {
/* 184 */           smj_rowWriter.setNullAt(4);
/* 185 */         } else {
/* 186 */           smj_rowWriter.write(4, smj_value8);
/* 187 */         }
/* 188 */
/* 189 */         if (smj_isNull7) {
/* 190 */           smj_rowWriter.setNullAt(5);
/* 191 */         } else {
/* 192 */           smj_rowWriter.write(5, smj_value9);
/* 193 */         }
/* 194 */
/* 195 */         if (smj_isNull8) {
/* 196 */           smj_rowWriter.setNullAt(6);
/* 197 */         } else {
/* 198 */           smj_rowWriter.write(6, smj_value10);
/* 199 */         }
/* 200 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 201 */         sort_sorter.insertRow((UnsafeRow)smj_result);
/* 202 */
/* 203 */       }
/* 204 */       if (shouldStop()) return;
/* 205 */     }
/* 206 */
/* 207 */   }
/* 208 */
/* 209 */   protected void processNext() throws java.io.IOException {
/* 210 */     if (sort_needToSort) {
/* 211 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 212 */       sort_addToSorter();
/* 213 */       sort_sortedIter = sort_sorter.sort();
/* 214 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 215 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 216 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 217 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 218 */       sort_needToSort = false;
/* 219 */     }
/* 220 */
/* 221 */     while (sort_sortedIter.hasNext()) {
/* 222 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 223 */
/* 224 */       append(sort_outputRow);
/* 225 */
/* 226 */       if (shouldStop()) return;
/* 227 */     }
/* 228 */   }
/* 229 */ }
