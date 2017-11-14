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
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 031 */   private UnsafeRow filter_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_numOutputRows;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_aggTime;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     wholestagecodegen_init_0();
/* 051 */     wholestagecodegen_init_1();
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   private void wholestagecodegen_init_0() {
/* 056 */     sort_needToSort = true;
/* 057 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 058 */     sort_sorter = sort_plan.createSorter();
/* 059 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 060 */
/* 061 */     agg_initAgg = false;
/* 062 */
/* 063 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[1];
/* 064 */
/* 065 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 066 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 067 */     inputadapter_input = inputs[0];
/* 068 */     agg_result = new UnsafeRow(1);
/* 069 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 070 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 071 */
/* 072 */     agg_result1 = new UnsafeRow(2);
/* 073 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 074 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 075 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 080 */     agg_hashMap = agg_plan.createHashMap();
/* 081 */
/* 082 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 083 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 084 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 085 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 086 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 087 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 088 */
/* 089 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 090 */
/* 091 */       UnsafeRow agg_fastAggBuffer = null;
/* 092 */
/* 093 */       if (agg_fastAggBuffer == null) {
/* 094 */         // generate grouping key
/* 095 */         agg_rowWriter.zeroOutNullBytes();
/* 096 */
/* 097 */         if (inputadapter_isNull) {
/* 098 */           agg_rowWriter.setNullAt(0);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(0, inputadapter_value);
/* 101 */         }
/* 102 */         agg_value4 = 42;
/* 103 */
/* 104 */         if (!inputadapter_isNull) {
/* 105 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value4);
/* 106 */         }
/* 107 */         if (true) {
/* 108 */           // try to get the buffer from hash map
/* 109 */           agg_unsafeRowAggBuffer =
/* 110 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 111 */         }
/* 112 */         if (agg_unsafeRowAggBuffer == null) {
/* 113 */           if (agg_sorter == null) {
/* 114 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 115 */           } else {
/* 116 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 117 */           }
/* 118 */
/* 119 */           // the hash map had be spilled, it should have enough memory now,
/* 120 */           // try  to allocate buffer again.
/* 121 */           agg_unsafeRowAggBuffer =
/* 122 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 123 */           if (agg_unsafeRowAggBuffer == null) {
/* 124 */             // failed to allocate the first page
/* 125 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 126 */           }
/* 127 */         }
/* 128 */       }
/* 129 */
/* 130 */       if (agg_fastAggBuffer != null) {
/* 131 */         // update fast row
/* 132 */
/* 133 */       } else {
/* 134 */         // update unsafe row
/* 135 */
/* 136 */         // common sub-expressions
/* 137 */
/* 138 */         // evaluate aggregate function
/* 139 */         boolean agg_isNull6 = true;
/* 140 */         double agg_value7 = -1.0;
/* 141 */
/* 142 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 143 */         double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 144 */         boolean agg_isNull7 = agg_isNull8;
/* 145 */         double agg_value8 = agg_value9;
/* 146 */         if (agg_isNull7) {
/* 147 */           boolean agg_isNull9 = false;
/* 148 */           double agg_value10 = -1.0;
/* 149 */           if (!false) {
/* 150 */             agg_value10 = (double) 0;
/* 151 */           }
/* 152 */           if (!agg_isNull9) {
/* 153 */             agg_isNull7 = false;
/* 154 */             agg_value8 = agg_value10;
/* 155 */           }
/* 156 */         }
/* 157 */
/* 158 */         if (!inputadapter_isNull1) {
/* 159 */           agg_isNull6 = false; // resultCode could change nullability.
/* 160 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 161 */
/* 162 */         }
/* 163 */         boolean agg_isNull5 = agg_isNull6;
/* 164 */         double agg_value6 = agg_value7;
/* 165 */         if (agg_isNull5) {
/* 166 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 167 */           double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 168 */           if (!agg_isNull12) {
/* 169 */             agg_isNull5 = false;
/* 170 */             agg_value6 = agg_value13;
/* 171 */           }
/* 172 */         }
/* 173 */         // update unsafe row buffer
/* 174 */         if (!agg_isNull5) {
/* 175 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 176 */         } else {
/* 177 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 178 */         }
/* 179 */
/* 180 */       }
/* 181 */       if (shouldStop()) return;
/* 182 */     }
/* 183 */
/* 184 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 185 */   }
/* 186 */
/* 187 */   private void wholestagecodegen_init_1() {
/* 188 */     filter_result = new UnsafeRow(2);
/* 189 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 190 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 191 */     project_result = new UnsafeRow(1);
/* 192 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 193 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 194 */     this.sort_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 195 */     this.sort_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 196 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 197 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 198 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 199 */
/* 200 */   }
/* 201 */
/* 202 */   private void sort_addToSorter() throws java.io.IOException {
/* 203 */     if (!agg_initAgg) {
/* 204 */       agg_initAgg = true;
/* 205 */       long sort_beforeAgg = System.nanoTime();
/* 206 */       agg_doAggregateWithKeys();
/* 207 */       sort_aggTime.add((System.nanoTime() - sort_beforeAgg) / 1000000);
/* 208 */     }
/* 209 */
/* 210 */     // output the result
/* 211 */
/* 212 */     while (agg_mapIter.next()) {
/* 213 */       sort_numOutputRows.add(1);
/* 214 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 215 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 216 */
/* 217 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 218 */       int agg_value14 = agg_isNull13 ? -1 : (agg_aggKey.getInt(0));
/* 219 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 220 */       double agg_value15 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 221 */
/* 222 */       if (!(!(agg_isNull14))) continue;
/* 223 */
/* 224 */       boolean filter_isNull2 = true;
/* 225 */       boolean filter_value2 = false;
/* 226 */
/* 227 */       boolean filter_isNull4 = true;
/* 228 */       double filter_value4 = -1.0;
/* 229 */
/* 230 */       if (!false) {
/* 231 */         filter_isNull4 = false; // resultCode could change nullability.
/* 232 */         filter_value4 = 0.5D * 747003.8499999999D;
/* 233 */
/* 234 */       }
/* 235 */       if (!filter_isNull4) {
/* 236 */         filter_isNull2 = false; // resultCode could change nullability.
/* 237 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value15, filter_value4) > 0;
/* 238 */
/* 239 */       }
/* 240 */       if (filter_isNull2 || !filter_value2) continue;
/* 241 */
/* 242 */       filter_numOutputRows.add(1);
/* 243 */
/* 244 */       project_rowWriter.zeroOutNullBytes();
/* 245 */
/* 246 */       if (agg_isNull13) {
/* 247 */         project_rowWriter.setNullAt(0);
/* 248 */       } else {
/* 249 */         project_rowWriter.write(0, agg_value14);
/* 250 */       }
/* 251 */       sort_sorter.insertRow((UnsafeRow)project_result);
/* 252 */
/* 253 */       if (shouldStop()) return;
/* 254 */     }
/* 255 */
/* 256 */     agg_mapIter.close();
/* 257 */     if (agg_sorter == null) {
/* 258 */       agg_hashMap.free();
/* 259 */     }
/* 260 */
/* 261 */   }
/* 262 */
/* 263 */   protected void processNext() throws java.io.IOException {
/* 264 */     if (sort_needToSort) {
/* 265 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 266 */       sort_addToSorter();
/* 267 */       sort_sortedIter = sort_sorter.sort();
/* 268 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 269 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 270 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 271 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 272 */       sort_needToSort = false;
/* 273 */     }
/* 274 */
/* 275 */     while (sort_sortedIter.hasNext()) {
/* 276 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 277 */
/* 278 */       append(sort_outputRow);
/* 279 */
/* 280 */       if (shouldStop()) return;
/* 281 */     }
/* 282 */   }
/* 283 */ }
