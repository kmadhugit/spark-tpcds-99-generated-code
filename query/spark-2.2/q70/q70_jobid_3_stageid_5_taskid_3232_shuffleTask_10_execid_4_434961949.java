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
/* 013 */   private boolean agg_initAgg;
/* 014 */   private boolean agg_bufIsNull;
/* 015 */   private double agg_bufValue;
/* 016 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 017 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 018 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 019 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 022 */   private scala.collection.Iterator inputadapter_input;
/* 023 */   private UnsafeRow agg_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 026 */   private int agg_value4;
/* 027 */   private UnsafeRow agg_result1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_numOutputRows;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_aggTime;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     sort_needToSort = true;
/* 050 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 051 */     sort_sorter = sort_plan.createSorter();
/* 052 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 053 */
/* 054 */     agg_initAgg = false;
/* 055 */
/* 056 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[1];
/* 057 */
/* 058 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 059 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     inputadapter_input = inputs[0];
/* 061 */     agg_result = new UnsafeRow(1);
/* 062 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 063 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 064 */
/* 065 */     agg_result1 = new UnsafeRow(3);
/* 066 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 067 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 068 */     this.sort_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 069 */
/* 070 */   }
/* 071 */
/* 072 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 073 */     agg_hashMap = agg_plan.createHashMap();
/* 074 */
/* 075 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 076 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 077 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 078 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 079 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 080 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 081 */
/* 082 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 083 */
/* 084 */       UnsafeRow agg_fastAggBuffer = null;
/* 085 */
/* 086 */       if (agg_fastAggBuffer == null) {
/* 087 */         // generate grouping key
/* 088 */         agg_holder.reset();
/* 089 */
/* 090 */         agg_rowWriter.zeroOutNullBytes();
/* 091 */
/* 092 */         if (inputadapter_isNull) {
/* 093 */           agg_rowWriter.setNullAt(0);
/* 094 */         } else {
/* 095 */           agg_rowWriter.write(0, inputadapter_value);
/* 096 */         }
/* 097 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 098 */         agg_value4 = 42;
/* 099 */
/* 100 */         if (!inputadapter_isNull) {
/* 101 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value4);
/* 102 */         }
/* 103 */         if (true) {
/* 104 */           // try to get the buffer from hash map
/* 105 */           agg_unsafeRowAggBuffer =
/* 106 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 107 */         }
/* 108 */         if (agg_unsafeRowAggBuffer == null) {
/* 109 */           if (agg_sorter == null) {
/* 110 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 111 */           } else {
/* 112 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 113 */           }
/* 114 */
/* 115 */           // the hash map had be spilled, it should have enough memory now,
/* 116 */           // try  to allocate buffer again.
/* 117 */           agg_unsafeRowAggBuffer =
/* 118 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 119 */           if (agg_unsafeRowAggBuffer == null) {
/* 120 */             // failed to allocate the first page
/* 121 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 122 */           }
/* 123 */         }
/* 124 */       }
/* 125 */
/* 126 */       if (agg_fastAggBuffer != null) {
/* 127 */         // update fast row
/* 128 */
/* 129 */       } else {
/* 130 */         // update unsafe row
/* 131 */
/* 132 */         // common sub-expressions
/* 133 */
/* 134 */         // evaluate aggregate function
/* 135 */         boolean agg_isNull6 = true;
/* 136 */         double agg_value7 = -1.0;
/* 137 */
/* 138 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 139 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 140 */         boolean agg_isNull7 = agg_isNull8;
/* 141 */         double agg_value8 = agg_value9;
/* 142 */         if (agg_isNull7) {
/* 143 */           boolean agg_isNull9 = false;
/* 144 */           double agg_value10 = -1.0;
/* 145 */           if (!false) {
/* 146 */             agg_value10 = (double) 0;
/* 147 */           }
/* 148 */           if (!agg_isNull9) {
/* 149 */             agg_isNull7 = false;
/* 150 */             agg_value8 = agg_value10;
/* 151 */           }
/* 152 */         }
/* 153 */
/* 154 */         if (!inputadapter_isNull1) {
/* 155 */           agg_isNull6 = false; // resultCode could change nullability.
/* 156 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 157 */
/* 158 */         }
/* 159 */         boolean agg_isNull5 = agg_isNull6;
/* 160 */         double agg_value6 = agg_value7;
/* 161 */         if (agg_isNull5) {
/* 162 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 163 */           double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 164 */           if (!agg_isNull12) {
/* 165 */             agg_isNull5 = false;
/* 166 */             agg_value6 = agg_value13;
/* 167 */           }
/* 168 */         }
/* 169 */         // update unsafe row buffer
/* 170 */         if (!agg_isNull5) {
/* 171 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 172 */         } else {
/* 173 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 174 */         }
/* 175 */
/* 176 */       }
/* 177 */       if (shouldStop()) return;
/* 178 */     }
/* 179 */
/* 180 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 181 */   }
/* 182 */
/* 183 */   private void wholestagecodegen_init_1() {
/* 184 */     this.sort_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 185 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 186 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 187 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 188 */
/* 189 */   }
/* 190 */
/* 191 */   private void sort_addToSorter() throws java.io.IOException {
/* 192 */     if (!agg_initAgg) {
/* 193 */       agg_initAgg = true;
/* 194 */       long sort_beforeAgg = System.nanoTime();
/* 195 */       agg_doAggregateWithKeys();
/* 196 */       sort_aggTime.add((System.nanoTime() - sort_beforeAgg) / 1000000);
/* 197 */     }
/* 198 */
/* 199 */     // output the result
/* 200 */
/* 201 */     while (agg_mapIter.next()) {
/* 202 */       sort_numOutputRows.add(1);
/* 203 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 204 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 205 */
/* 206 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 207 */       UTF8String agg_value14 = agg_isNull13 ? null : (agg_aggKey.getUTF8String(0));
/* 208 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 209 */       double agg_value15 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 210 */
/* 211 */       agg_holder1.reset();
/* 212 */
/* 213 */       agg_rowWriter1.zeroOutNullBytes();
/* 214 */
/* 215 */       if (agg_isNull13) {
/* 216 */         agg_rowWriter1.setNullAt(0);
/* 217 */       } else {
/* 218 */         agg_rowWriter1.write(0, agg_value14);
/* 219 */       }
/* 220 */
/* 221 */       if (agg_isNull13) {
/* 222 */         agg_rowWriter1.setNullAt(1);
/* 223 */       } else {
/* 224 */         agg_rowWriter1.write(1, agg_value14);
/* 225 */       }
/* 226 */
/* 227 */       if (agg_isNull14) {
/* 228 */         agg_rowWriter1.setNullAt(2);
/* 229 */       } else {
/* 230 */         agg_rowWriter1.write(2, agg_value15);
/* 231 */       }
/* 232 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 233 */       sort_sorter.insertRow((UnsafeRow)agg_result1);
/* 234 */
/* 235 */       if (shouldStop()) return;
/* 236 */     }
/* 237 */
/* 238 */     agg_mapIter.close();
/* 239 */     if (agg_sorter == null) {
/* 240 */       agg_hashMap.free();
/* 241 */     }
/* 242 */
/* 243 */   }
/* 244 */
/* 245 */   protected void processNext() throws java.io.IOException {
/* 246 */     if (sort_needToSort) {
/* 247 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 248 */       sort_addToSorter();
/* 249 */       sort_sortedIter = sort_sorter.sort();
/* 250 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 251 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 252 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 253 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 254 */       sort_needToSort = false;
/* 255 */     }
/* 256 */
/* 257 */     while (sort_sortedIter.hasNext()) {
/* 258 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 259 */
/* 260 */       append(sort_outputRow);
/* 261 */
/* 262 */       if (shouldStop()) return;
/* 263 */     }
/* 264 */   }
/* 265 */ }
