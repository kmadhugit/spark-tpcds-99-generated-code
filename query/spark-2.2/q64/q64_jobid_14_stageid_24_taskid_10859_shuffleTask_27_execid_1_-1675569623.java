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
/* 016 */   private boolean agg_bufIsNull1;
/* 017 */   private double agg_bufValue1;
/* 018 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 019 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 020 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 021 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 024 */   private scala.collection.Iterator inputadapter_input;
/* 025 */   private UnsafeRow agg_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 028 */   private int agg_value6;
/* 029 */   private UnsafeRow agg_result1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 033 */   private UnsafeRow filter_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 036 */   private UnsafeRow project_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_numOutputRows;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_aggTime;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 044 */
/* 045 */   public GeneratedIterator(Object[] references) {
/* 046 */     this.references = references;
/* 047 */   }
/* 048 */
/* 049 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 050 */     partitionIndex = index;
/* 051 */     this.inputs = inputs;
/* 052 */     wholestagecodegen_init_0();
/* 053 */     wholestagecodegen_init_1();
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */   private void wholestagecodegen_init_0() {
/* 058 */     sort_needToSort = true;
/* 059 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 060 */     sort_sorter = sort_plan.createSorter();
/* 061 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 062 */
/* 063 */     agg_initAgg = false;
/* 064 */
/* 065 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[1];
/* 066 */
/* 067 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 068 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 069 */     inputadapter_input = inputs[0];
/* 070 */     agg_result = new UnsafeRow(1);
/* 071 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 072 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 073 */
/* 074 */     agg_result1 = new UnsafeRow(3);
/* 075 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 076 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 077 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 082 */     agg_hashMap = agg_plan.createHashMap();
/* 083 */
/* 084 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 085 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 086 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 087 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 088 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 089 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 090 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 091 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 092 */
/* 093 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 094 */
/* 095 */       UnsafeRow agg_fastAggBuffer = null;
/* 096 */
/* 097 */       if (agg_fastAggBuffer == null) {
/* 098 */         // generate grouping key
/* 099 */         agg_rowWriter.zeroOutNullBytes();
/* 100 */
/* 101 */         if (inputadapter_isNull) {
/* 102 */           agg_rowWriter.setNullAt(0);
/* 103 */         } else {
/* 104 */           agg_rowWriter.write(0, inputadapter_value);
/* 105 */         }
/* 106 */         agg_value6 = 42;
/* 107 */
/* 108 */         if (!inputadapter_isNull) {
/* 109 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 110 */         }
/* 111 */         if (true) {
/* 112 */           // try to get the buffer from hash map
/* 113 */           agg_unsafeRowAggBuffer =
/* 114 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 115 */         }
/* 116 */         if (agg_unsafeRowAggBuffer == null) {
/* 117 */           if (agg_sorter == null) {
/* 118 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 119 */           } else {
/* 120 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 121 */           }
/* 122 */
/* 123 */           // the hash map had be spilled, it should have enough memory now,
/* 124 */           // try  to allocate buffer again.
/* 125 */           agg_unsafeRowAggBuffer =
/* 126 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 127 */           if (agg_unsafeRowAggBuffer == null) {
/* 128 */             // failed to allocate the first page
/* 129 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 130 */           }
/* 131 */         }
/* 132 */       }
/* 133 */
/* 134 */       if (agg_fastAggBuffer != null) {
/* 135 */         // update fast row
/* 136 */
/* 137 */       } else {
/* 138 */         // update unsafe row
/* 139 */
/* 140 */         // common sub-expressions
/* 141 */
/* 142 */         // evaluate aggregate function
/* 143 */         boolean agg_isNull7 = true;
/* 144 */         double agg_value9 = -1.0;
/* 145 */
/* 146 */         boolean agg_isNull9 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 147 */         double agg_value11 = agg_isNull9 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 148 */         boolean agg_isNull8 = agg_isNull9;
/* 149 */         double agg_value10 = agg_value11;
/* 150 */         if (agg_isNull8) {
/* 151 */           boolean agg_isNull10 = false;
/* 152 */           double agg_value12 = -1.0;
/* 153 */           if (!false) {
/* 154 */             agg_value12 = (double) 0;
/* 155 */           }
/* 156 */           if (!agg_isNull10) {
/* 157 */             agg_isNull8 = false;
/* 158 */             agg_value10 = agg_value12;
/* 159 */           }
/* 160 */         }
/* 161 */
/* 162 */         if (!inputadapter_isNull1) {
/* 163 */           agg_isNull7 = false; // resultCode could change nullability.
/* 164 */           agg_value9 = agg_value10 + inputadapter_value1;
/* 165 */
/* 166 */         }
/* 167 */         boolean agg_isNull6 = agg_isNull7;
/* 168 */         double agg_value8 = agg_value9;
/* 169 */         if (agg_isNull6) {
/* 170 */           boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 171 */           double agg_value15 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 172 */           if (!agg_isNull13) {
/* 173 */             agg_isNull6 = false;
/* 174 */             agg_value8 = agg_value15;
/* 175 */           }
/* 176 */         }
/* 177 */         boolean agg_isNull15 = true;
/* 178 */         double agg_value17 = -1.0;
/* 179 */
/* 180 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 181 */         double agg_value19 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 182 */         boolean agg_isNull16 = agg_isNull17;
/* 183 */         double agg_value18 = agg_value19;
/* 184 */         if (agg_isNull16) {
/* 185 */           boolean agg_isNull18 = false;
/* 186 */           double agg_value20 = -1.0;
/* 187 */           if (!false) {
/* 188 */             agg_value20 = (double) 0;
/* 189 */           }
/* 190 */           if (!agg_isNull18) {
/* 191 */             agg_isNull16 = false;
/* 192 */             agg_value18 = agg_value20;
/* 193 */           }
/* 194 */         }
/* 195 */
/* 196 */         if (!inputadapter_isNull2) {
/* 197 */           agg_isNull15 = false; // resultCode could change nullability.
/* 198 */           agg_value17 = agg_value18 + inputadapter_value2;
/* 199 */
/* 200 */         }
/* 201 */         boolean agg_isNull14 = agg_isNull15;
/* 202 */         double agg_value16 = agg_value17;
/* 203 */         if (agg_isNull14) {
/* 204 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 205 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 206 */           if (!agg_isNull21) {
/* 207 */             agg_isNull14 = false;
/* 208 */             agg_value16 = agg_value23;
/* 209 */           }
/* 210 */         }
/* 211 */         // update unsafe row buffer
/* 212 */         if (!agg_isNull6) {
/* 213 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value8);
/* 214 */         } else {
/* 215 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 216 */         }
/* 217 */
/* 218 */         if (!agg_isNull14) {
/* 219 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value16);
/* 220 */         } else {
/* 221 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 222 */         }
/* 223 */
/* 224 */       }
/* 225 */       if (shouldStop()) return;
/* 226 */     }
/* 227 */
/* 228 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 229 */   }
/* 230 */
/* 231 */   private void wholestagecodegen_init_1() {
/* 232 */     filter_result = new UnsafeRow(3);
/* 233 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 234 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 235 */     project_result = new UnsafeRow(1);
/* 236 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 237 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 238 */     this.sort_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 239 */     this.sort_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 240 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 241 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 242 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 243 */
/* 244 */   }
/* 245 */
/* 246 */   private void sort_addToSorter() throws java.io.IOException {
/* 247 */     if (!agg_initAgg) {
/* 248 */       agg_initAgg = true;
/* 249 */       long sort_beforeAgg = System.nanoTime();
/* 250 */       agg_doAggregateWithKeys();
/* 251 */       sort_aggTime.add((System.nanoTime() - sort_beforeAgg) / 1000000);
/* 252 */     }
/* 253 */
/* 254 */     // output the result
/* 255 */
/* 256 */     while (agg_mapIter.next()) {
/* 257 */       sort_numOutputRows.add(1);
/* 258 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 259 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 260 */
/* 261 */       boolean agg_isNull22 = agg_aggKey.isNullAt(0);
/* 262 */       int agg_value24 = agg_isNull22 ? -1 : (agg_aggKey.getInt(0));
/* 263 */       boolean agg_isNull23 = agg_aggBuffer.isNullAt(0);
/* 264 */       double agg_value25 = agg_isNull23 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 265 */       boolean agg_isNull24 = agg_aggBuffer.isNullAt(1);
/* 266 */       double agg_value26 = agg_isNull24 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 267 */
/* 268 */       if (!(!(agg_isNull23))) continue;
/* 269 */
/* 270 */       if (!(!(agg_isNull24))) continue;
/* 271 */
/* 272 */       boolean filter_isNull4 = false;
/* 273 */
/* 274 */       boolean filter_isNull6 = false;
/* 275 */
/* 276 */       double filter_value6 = -1.0;
/* 277 */       filter_value6 = 2.0D * agg_value26;
/* 278 */       boolean filter_value4 = false;
/* 279 */       filter_value4 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value25, filter_value6) > 0;
/* 280 */       if (!filter_value4) continue;
/* 281 */
/* 282 */       filter_numOutputRows.add(1);
/* 283 */
/* 284 */       project_rowWriter.zeroOutNullBytes();
/* 285 */
/* 286 */       if (agg_isNull22) {
/* 287 */         project_rowWriter.setNullAt(0);
/* 288 */       } else {
/* 289 */         project_rowWriter.write(0, agg_value24);
/* 290 */       }
/* 291 */       sort_sorter.insertRow((UnsafeRow)project_result);
/* 292 */
/* 293 */       if (shouldStop()) return;
/* 294 */     }
/* 295 */
/* 296 */     agg_mapIter.close();
/* 297 */     if (agg_sorter == null) {
/* 298 */       agg_hashMap.free();
/* 299 */     }
/* 300 */
/* 301 */   }
/* 302 */
/* 303 */   protected void processNext() throws java.io.IOException {
/* 304 */     if (sort_needToSort) {
/* 305 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 306 */       sort_addToSorter();
/* 307 */       sort_sortedIter = sort_sorter.sort();
/* 308 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 309 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 310 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 311 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 312 */       sort_needToSort = false;
/* 313 */     }
/* 314 */
/* 315 */     while (sort_sortedIter.hasNext()) {
/* 316 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 317 */
/* 318 */       append(sort_outputRow);
/* 319 */
/* 320 */       if (shouldStop()) return;
/* 321 */     }
/* 322 */   }
/* 323 */ }
