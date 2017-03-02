/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator scan_input;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 018 */   private long scan_scanTime1;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 020 */   private int scan_batchIdx;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 024 */   private UnsafeRow scan_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 035 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 036 */   private UnsafeRow bhj_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 040 */   private UnsafeRow bhj_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 043 */   private UnsafeRow project_result1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 046 */   private UnsafeRow agg_result;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 049 */   private int agg_value2;
/* 050 */   private UnsafeRow agg_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 055 */
/* 056 */   public GeneratedIterator(Object[] references) {
/* 057 */     this.references = references;
/* 058 */   }
/* 059 */
/* 060 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 061 */     partitionIndex = index;
/* 062 */     this.inputs = inputs;
/* 063 */     wholestagecodegen_init_0();
/* 064 */     wholestagecodegen_init_1();
/* 065 */     wholestagecodegen_init_2();
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private void wholestagecodegen_init_0() {
/* 070 */     agg_initAgg = false;
/* 071 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 072 */
/* 073 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 074 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 075 */     scan_input = inputs[0];
/* 076 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 077 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 078 */     scan_scanTime1 = 0;
/* 079 */     scan_batch = null;
/* 080 */     scan_batchIdx = 0;
/* 081 */     scan_colInstance0 = null;
/* 082 */     scan_colInstance1 = null;
/* 083 */     scan_colInstance2 = null;
/* 084 */     scan_result = new UnsafeRow(3);
/* 085 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 086 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 087 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 088 */     filter_result = new UnsafeRow(3);
/* 089 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 090 */
/* 091 */   }
/* 092 */
/* 093 */   private void scan_nextBatch() throws java.io.IOException {
/* 094 */     long getBatchStart = System.nanoTime();
/* 095 */     if (scan_input.hasNext()) {
/* 096 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 097 */       scan_numOutputRows.add(scan_batch.numRows());
/* 098 */       scan_batchIdx = 0;
/* 099 */       scan_colInstance0 = scan_batch.column(0);
/* 100 */       scan_colInstance1 = scan_batch.column(1);
/* 101 */       scan_colInstance2 = scan_batch.column(2);
/* 102 */
/* 103 */     }
/* 104 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 105 */   }
/* 106 */
/* 107 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 108 */     agg_hashMap = agg_plan.createHashMap();
/* 109 */
/* 110 */     if (scan_batch == null) {
/* 111 */       scan_nextBatch();
/* 112 */     }
/* 113 */     while (scan_batch != null) {
/* 114 */       int numRows = scan_batch.numRows();
/* 115 */       while (scan_batchIdx < numRows) {
/* 116 */         int scan_rowIdx = scan_batchIdx++;
/* 117 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 118 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 119 */
/* 120 */         if (!(!(scan_isNull))) continue;
/* 121 */
/* 122 */         boolean filter_isNull2 = false;
/* 123 */
/* 124 */         boolean filter_value2 = false;
/* 125 */         filter_value2 = scan_value >= 738;
/* 126 */         if (!filter_value2) continue;
/* 127 */         boolean filter_isNull5 = false;
/* 128 */
/* 129 */         boolean filter_value5 = false;
/* 130 */         filter_value5 = scan_value <= 778;
/* 131 */         if (!filter_value5) continue;
/* 132 */
/* 133 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 134 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 135 */
/* 136 */         if (!(!(scan_isNull1))) continue;
/* 137 */
/* 138 */         filter_numOutputRows.add(1);
/* 139 */
/* 140 */         // generate join key for stream side
/* 141 */
/* 142 */         bhj_holder.reset();
/* 143 */
/* 144 */         bhj_rowWriter.write(0, scan_value1);
/* 145 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 146 */
/* 147 */         // find matches from HashedRelation
/* 148 */         UnsafeRow bhj_matched = bhj_result.anyNull() ? null: (UnsafeRow)bhj_relation.getValue(bhj_result);
/* 149 */         if (bhj_matched == null) continue;
/* 150 */
/* 151 */         bhj_numOutputRows.add(1);
/* 152 */
/* 153 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 154 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 155 */
/* 156 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 157 */
/* 158 */         UnsafeRow agg_fastAggBuffer = null;
/* 159 */
/* 160 */         if (agg_fastAggBuffer == null) {
/* 161 */           // generate grouping key
/* 162 */           agg_holder.reset();
/* 163 */
/* 164 */           agg_rowWriter.zeroOutNullBytes();
/* 165 */
/* 166 */           if (scan_isNull2) {
/* 167 */             agg_rowWriter.setNullAt(0);
/* 168 */           } else {
/* 169 */             agg_rowWriter.write(0, scan_value2);
/* 170 */           }
/* 171 */           agg_result.setTotalSize(agg_holder.totalSize());
/* 172 */           agg_value2 = 42;
/* 173 */
/* 174 */           if (!scan_isNull2) {
/* 175 */             agg_value2 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value2);
/* 176 */           }
/* 177 */           if (true) {
/* 178 */             // try to get the buffer from hash map
/* 179 */             agg_unsafeRowAggBuffer =
/* 180 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 181 */           }
/* 182 */           if (agg_unsafeRowAggBuffer == null) {
/* 183 */             if (agg_sorter == null) {
/* 184 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 185 */             } else {
/* 186 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 187 */             }
/* 188 */
/* 189 */             // the hash map had be spilled, it should have enough memory now,
/* 190 */             // try  to allocate buffer again.
/* 191 */             agg_unsafeRowAggBuffer =
/* 192 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value2);
/* 193 */             if (agg_unsafeRowAggBuffer == null) {
/* 194 */               // failed to allocate the first page
/* 195 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 196 */             }
/* 197 */           }
/* 198 */         }
/* 199 */
/* 200 */         if (agg_fastAggBuffer != null) {
/* 201 */           // update fast row
/* 202 */
/* 203 */         } else {
/* 204 */           // update unsafe row
/* 205 */
/* 206 */           // common sub-expressions
/* 207 */
/* 208 */           // evaluate aggregate function
/* 209 */
/* 210 */           // update unsafe row buffer
/* 211 */
/* 212 */         }
/* 213 */         if (shouldStop()) return;
/* 214 */       }
/* 215 */       scan_batch = null;
/* 216 */       scan_nextBatch();
/* 217 */     }
/* 218 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 219 */     scan_scanTime1 = 0;
/* 220 */
/* 221 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 222 */   }
/* 223 */
/* 224 */   private void wholestagecodegen_init_2() {
/* 225 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 3);
/* 226 */     project_result1 = new UnsafeRow(1);
/* 227 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 228 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 229 */     agg_result = new UnsafeRow(1);
/* 230 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 231 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 232 */
/* 233 */     agg_result1 = new UnsafeRow(1);
/* 234 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 235 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 236 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 237 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 238 */
/* 239 */   }
/* 240 */
/* 241 */   private void wholestagecodegen_init_1() {
/* 242 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 243 */     project_result = new UnsafeRow(2);
/* 244 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 245 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 246 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 247 */
/* 248 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 249 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 250 */
/* 251 */     bhj_result = new UnsafeRow(1);
/* 252 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 253 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 1);
/* 254 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 255 */     bhj_result1 = new UnsafeRow(3);
/* 256 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 257 */
/* 258 */   }
/* 259 */
/* 260 */   protected void processNext() throws java.io.IOException {
/* 261 */     if (!agg_initAgg) {
/* 262 */       agg_initAgg = true;
/* 263 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 264 */       agg_doAggregateWithKeys();
/* 265 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 266 */     }
/* 267 */
/* 268 */     // output the result
/* 269 */
/* 270 */     while (agg_mapIter.next()) {
/* 271 */       wholestagecodegen_numOutputRows.add(1);
/* 272 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 273 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 274 */
/* 275 */       boolean agg_isNull4 = agg_aggKey.isNullAt(0);
/* 276 */       UTF8String agg_value4 = agg_isNull4 ? null : (agg_aggKey.getUTF8String(0));
/* 277 */       agg_holder1.reset();
/* 278 */
/* 279 */       agg_rowWriter1.zeroOutNullBytes();
/* 280 */
/* 281 */       if (agg_isNull4) {
/* 282 */         agg_rowWriter1.setNullAt(0);
/* 283 */       } else {
/* 284 */         agg_rowWriter1.write(0, agg_value4);
/* 285 */       }
/* 286 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 287 */       append(agg_result1);
/* 288 */
/* 289 */       if (shouldStop()) return;
/* 290 */     }
/* 291 */
/* 292 */     agg_mapIter.close();
/* 293 */     if (agg_sorter == null) {
/* 294 */       agg_hashMap.free();
/* 295 */     }
/* 296 */   }
/* 297 */ }
