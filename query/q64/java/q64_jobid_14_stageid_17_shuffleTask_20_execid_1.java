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
/* 084 */     while (inputadapter_input.hasNext()) {
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
/* 141 */         boolean agg_isNull6 = false;
/* 142 */         double agg_value8 = -1.0;
/* 143 */         if (!false) {
/* 144 */           agg_value8 = (double) 0;
/* 145 */         }
/* 146 */         // evaluate aggregate function
/* 147 */         boolean agg_isNull9 = true;
/* 148 */         double agg_value11 = -1.0;
/* 149 */
/* 150 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 151 */         double agg_value13 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 152 */         boolean agg_isNull10 = agg_isNull11;
/* 153 */         double agg_value12 = agg_value13;
/* 154 */         if (agg_isNull10) {
/* 155 */           if (!agg_isNull6) {
/* 156 */             agg_isNull10 = false;
/* 157 */             agg_value12 = agg_value8;
/* 158 */           }
/* 159 */         }
/* 160 */
/* 161 */         if (!inputadapter_isNull1) {
/* 162 */           agg_isNull9 = false; // resultCode could change nullability.
/* 163 */           agg_value11 = agg_value12 + inputadapter_value1;
/* 164 */
/* 165 */         }
/* 166 */         boolean agg_isNull8 = agg_isNull9;
/* 167 */         double agg_value10 = agg_value11;
/* 168 */         if (agg_isNull8) {
/* 169 */           boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 170 */           double agg_value15 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 171 */           if (!agg_isNull13) {
/* 172 */             agg_isNull8 = false;
/* 173 */             agg_value10 = agg_value15;
/* 174 */           }
/* 175 */         }
/* 176 */         boolean agg_isNull15 = true;
/* 177 */         double agg_value17 = -1.0;
/* 178 */
/* 179 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 180 */         double agg_value19 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 181 */         boolean agg_isNull16 = agg_isNull17;
/* 182 */         double agg_value18 = agg_value19;
/* 183 */         if (agg_isNull16) {
/* 184 */           if (!agg_isNull6) {
/* 185 */             agg_isNull16 = false;
/* 186 */             agg_value18 = agg_value8;
/* 187 */           }
/* 188 */         }
/* 189 */
/* 190 */         if (!inputadapter_isNull2) {
/* 191 */           agg_isNull15 = false; // resultCode could change nullability.
/* 192 */           agg_value17 = agg_value18 + inputadapter_value2;
/* 193 */
/* 194 */         }
/* 195 */         boolean agg_isNull14 = agg_isNull15;
/* 196 */         double agg_value16 = agg_value17;
/* 197 */         if (agg_isNull14) {
/* 198 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 199 */           double agg_value21 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 200 */           if (!agg_isNull19) {
/* 201 */             agg_isNull14 = false;
/* 202 */             agg_value16 = agg_value21;
/* 203 */           }
/* 204 */         }
/* 205 */         // update unsafe row buffer
/* 206 */         if (!agg_isNull8) {
/* 207 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value10);
/* 208 */         } else {
/* 209 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 210 */         }
/* 211 */
/* 212 */         if (!agg_isNull14) {
/* 213 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value16);
/* 214 */         } else {
/* 215 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 216 */         }
/* 217 */
/* 218 */       }
/* 219 */       if (shouldStop()) return;
/* 220 */     }
/* 221 */
/* 222 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 223 */   }
/* 224 */
/* 225 */   private void wholestagecodegen_init_1() {
/* 226 */     filter_result = new UnsafeRow(3);
/* 227 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 228 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 229 */     project_result = new UnsafeRow(1);
/* 230 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 231 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 232 */     this.sort_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 233 */     this.sort_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 234 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 235 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 236 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 237 */
/* 238 */   }
/* 239 */
/* 240 */   private void sort_addToSorter() throws java.io.IOException {
/* 241 */     if (!agg_initAgg) {
/* 242 */       agg_initAgg = true;
/* 243 */       long sort_beforeAgg = System.nanoTime();
/* 244 */       agg_doAggregateWithKeys();
/* 245 */       sort_aggTime.add((System.nanoTime() - sort_beforeAgg) / 1000000);
/* 246 */     }
/* 247 */
/* 248 */     // output the result
/* 249 */
/* 250 */     while (agg_mapIter.next()) {
/* 251 */       sort_numOutputRows.add(1);
/* 252 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 253 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 254 */
/* 255 */       boolean agg_isNull20 = agg_aggKey.isNullAt(0);
/* 256 */       int agg_value22 = agg_isNull20 ? -1 : (agg_aggKey.getInt(0));
/* 257 */       boolean agg_isNull21 = agg_aggBuffer.isNullAt(0);
/* 258 */       double agg_value23 = agg_isNull21 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 259 */       boolean agg_isNull22 = agg_aggBuffer.isNullAt(1);
/* 260 */       double agg_value24 = agg_isNull22 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 261 */
/* 262 */       if (!(!(agg_isNull21))) continue;
/* 263 */
/* 264 */       if (!(!(agg_isNull22))) continue;
/* 265 */
/* 266 */       boolean filter_isNull4 = false;
/* 267 */
/* 268 */       boolean filter_isNull6 = false;
/* 269 */
/* 270 */       double filter_value6 = -1.0;
/* 271 */       filter_value6 = 2.0D * agg_value24;
/* 272 */       boolean filter_value4 = false;
/* 273 */       filter_value4 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value23, filter_value6) > 0;
/* 274 */       if (!filter_value4) continue;
/* 275 */
/* 276 */       filter_numOutputRows.add(1);
/* 277 */
/* 278 */       project_rowWriter.zeroOutNullBytes();
/* 279 */
/* 280 */       if (agg_isNull20) {
/* 281 */         project_rowWriter.setNullAt(0);
/* 282 */       } else {
/* 283 */         project_rowWriter.write(0, agg_value22);
/* 284 */       }
/* 285 */       sort_sorter.insertRow((UnsafeRow)project_result);
/* 286 */
/* 287 */       if (shouldStop()) return;
/* 288 */     }
/* 289 */
/* 290 */     agg_mapIter.close();
/* 291 */     if (agg_sorter == null) {
/* 292 */       agg_hashMap.free();
/* 293 */     }
/* 294 */
/* 295 */   }
/* 296 */
/* 297 */   protected void processNext() throws java.io.IOException {
/* 298 */     if (sort_needToSort) {
/* 299 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 300 */       sort_addToSorter();
/* 301 */       sort_sortedIter = sort_sorter.sort();
/* 302 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 303 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 304 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 305 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 306 */       sort_needToSort = false;
/* 307 */     }
/* 308 */
/* 309 */     while (sort_sortedIter.hasNext()) {
/* 310 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 311 */
/* 312 */       append(sort_outputRow);
/* 313 */
/* 314 */       if (shouldStop()) return;
/* 315 */     }
/* 316 */   }
/* 317 */ }
