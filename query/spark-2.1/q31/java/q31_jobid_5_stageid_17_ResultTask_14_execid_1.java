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
/* 026 */   private UTF8String smj_value7;
/* 027 */   private boolean smj_isNull5;
/* 028 */   private double smj_value8;
/* 029 */   private boolean smj_isNull6;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 031 */   private UnsafeRow smj_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 040 */
/* 041 */   public GeneratedIterator(Object[] references) {
/* 042 */     this.references = references;
/* 043 */   }
/* 044 */
/* 045 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 046 */     partitionIndex = index;
/* 047 */     this.inputs = inputs;
/* 048 */     wholestagecodegen_init_0();
/* 049 */     wholestagecodegen_init_1();
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private void wholestagecodegen_init_0() {
/* 054 */     sort_needToSort = true;
/* 055 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 056 */     sort_sorter = sort_plan.createSorter();
/* 057 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 058 */
/* 059 */     smj_leftInput = inputs[0];
/* 060 */     smj_rightInput = inputs[1];
/* 061 */
/* 062 */     smj_rightRow = null;
/* 063 */
/* 064 */     smj_matches = new java.util.ArrayList();
/* 065 */
/* 066 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 067 */     smj_result = new UnsafeRow(7);
/* 068 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 069 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
/* 070 */     project_result = new UnsafeRow(5);
/* 071 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 072 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 073 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 074 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   private boolean findNextInnerJoinRows(
/* 079 */     scala.collection.Iterator leftIter,
/* 080 */     scala.collection.Iterator rightIter) {
/* 081 */     smj_leftRow = null;
/* 082 */     int comp = 0;
/* 083 */     while (smj_leftRow == null) {
/* 084 */       if (!leftIter.hasNext()) return false;
/* 085 */       smj_leftRow = (InternalRow) leftIter.next();
/* 086 */
/* 087 */       boolean smj_isNull = smj_leftRow.isNullAt(3);
/* 088 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(3));
/* 089 */       if (smj_isNull) {
/* 090 */         smj_leftRow = null;
/* 091 */         continue;
/* 092 */       }
/* 093 */       if (!smj_matches.isEmpty()) {
/* 094 */         comp = 0;
/* 095 */         if (comp == 0) {
/* 096 */           comp = smj_value.compare(smj_value3);
/* 097 */         }
/* 098 */
/* 099 */         if (comp == 0) {
/* 100 */           return true;
/* 101 */         }
/* 102 */         smj_matches.clear();
/* 103 */       }
/* 104 */
/* 105 */       do {
/* 106 */         if (smj_rightRow == null) {
/* 107 */           if (!rightIter.hasNext()) {
/* 108 */             smj_value3 = smj_value.clone();
/* 109 */             return !smj_matches.isEmpty();
/* 110 */           }
/* 111 */           smj_rightRow = (InternalRow) rightIter.next();
/* 112 */
/* 113 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 114 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 115 */           if (smj_isNull1) {
/* 116 */             smj_rightRow = null;
/* 117 */             continue;
/* 118 */           }
/* 119 */           smj_value2 = smj_value1.clone();
/* 120 */         }
/* 121 */
/* 122 */         comp = 0;
/* 123 */         if (comp == 0) {
/* 124 */           comp = smj_value.compare(smj_value2);
/* 125 */         }
/* 126 */
/* 127 */         if (comp > 0) {
/* 128 */           smj_rightRow = null;
/* 129 */         } else if (comp < 0) {
/* 130 */           if (!smj_matches.isEmpty()) {
/* 131 */             smj_value3 = smj_value.clone();
/* 132 */             return true;
/* 133 */           }
/* 134 */           smj_leftRow = null;
/* 135 */         } else {
/* 136 */           smj_matches.add(smj_rightRow.copy());
/* 137 */           smj_rightRow = null;;
/* 138 */         }
/* 139 */       } while (smj_leftRow != null);
/* 140 */     }
/* 141 */     return false; // unreachable
/* 142 */   }
/* 143 */
/* 144 */   private void wholestagecodegen_init_1() {
/* 145 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 146 */
/* 147 */   }
/* 148 */
/* 149 */   private void sort_addToSorter() throws java.io.IOException {
/* 150 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 151 */       int smj_size = smj_matches.size();
/* 152 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 153 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 154 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 155 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 156 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 157 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 158 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 159 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 160 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 161 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 162 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 163 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 164 */
/* 165 */         smj_numOutputRows.add(1);
/* 166 */
/* 167 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(1);
/* 168 */         double smj_value10 = smj_isNull8 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 169 */         project_holder.reset();
/* 170 */
/* 171 */         project_rowWriter.zeroOutNullBytes();
/* 172 */
/* 173 */         if (smj_isNull2) {
/* 174 */           project_rowWriter.setNullAt(0);
/* 175 */         } else {
/* 176 */           project_rowWriter.write(0, smj_value4);
/* 177 */         }
/* 178 */
/* 179 */         if (smj_isNull3) {
/* 180 */           project_rowWriter.setNullAt(1);
/* 181 */         } else {
/* 182 */           project_rowWriter.write(1, smj_value5);
/* 183 */         }
/* 184 */
/* 185 */         if (smj_isNull4) {
/* 186 */           project_rowWriter.setNullAt(2);
/* 187 */         } else {
/* 188 */           project_rowWriter.write(2, smj_value6);
/* 189 */         }
/* 190 */
/* 191 */         if (smj_isNull6) {
/* 192 */           project_rowWriter.setNullAt(3);
/* 193 */         } else {
/* 194 */           project_rowWriter.write(3, smj_value8);
/* 195 */         }
/* 196 */
/* 197 */         if (smj_isNull8) {
/* 198 */           project_rowWriter.setNullAt(4);
/* 199 */         } else {
/* 200 */           project_rowWriter.write(4, smj_value10);
/* 201 */         }
/* 202 */         project_result.setTotalSize(project_holder.totalSize());
/* 203 */         sort_sorter.insertRow((UnsafeRow)project_result);
/* 204 */
/* 205 */       }
/* 206 */       if (shouldStop()) return;
/* 207 */     }
/* 208 */
/* 209 */   }
/* 210 */
/* 211 */   protected void processNext() throws java.io.IOException {
/* 212 */     if (sort_needToSort) {
/* 213 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 214 */       sort_addToSorter();
/* 215 */       sort_sortedIter = sort_sorter.sort();
/* 216 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 217 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 218 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 219 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 220 */       sort_needToSort = false;
/* 221 */     }
/* 222 */
/* 223 */     while (sort_sortedIter.hasNext()) {
/* 224 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 225 */
/* 226 */       append(sort_outputRow);
/* 227 */
/* 228 */       if (shouldStop()) return;
/* 229 */     }
/* 230 */   }
/* 231 */ }
