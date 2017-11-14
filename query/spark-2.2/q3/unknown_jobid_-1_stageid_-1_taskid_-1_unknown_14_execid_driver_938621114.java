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
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 017 */   private UnsafeRow filter_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter1;
/* 021 */   private UnsafeRow project_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 024 */   private UnsafeRow agg_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 027 */   private int agg_value4;
/* 028 */   private UnsafeRow agg_result1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     wholestagecodegen_init_0();
/* 042 */     wholestagecodegen_init_1();
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */   private void wholestagecodegen_init_0() {
/* 047 */     agg_initAgg = false;
/* 048 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 049 */
/* 050 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 051 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 052 */     inputadapter_input = inputs[0];
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 054 */     filter_result = new UnsafeRow(1);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 1);
/* 057 */     this.filter_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 058 */     project_result = new UnsafeRow(2);
/* 059 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 060 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 061 */
/* 062 */   }
/* 063 */
/* 064 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 065 */     agg_hashMap = agg_plan.createHashMap();
/* 066 */
/* 067 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 068 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 069 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 070 */       InternalRow inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getStruct(0, 2));
/* 071 */
/* 072 */       boolean filter_isNull1 = inputadapter_isNull;
/* 073 */       UTF8String filter_value1 = null;
/* 074 */
/* 075 */       if (!inputadapter_isNull) {
/* 076 */         if (inputadapter_value.isNullAt(0)) {
/* 077 */           filter_isNull1 = true;
/* 078 */         } else {
/* 079 */           filter_value1 = inputadapter_value.getUTF8String(0);
/* 080 */         }
/* 081 */
/* 082 */       }
/* 083 */       boolean filter_value = false;
/* 084 */       boolean filter_isNull = filter_isNull1;
/* 085 */       if (!filter_isNull) {
/* 086 */         if (!filter_value) {
/* 087 */           if (false) {
/* 088 */             filter_isNull = true;
/* 089 */           } else if (filter_value1.equals(((UTF8String) references[4]))) {
/* 090 */             filter_isNull = false;
/* 091 */             filter_value = true;
/* 092 */           }
/* 093 */         }
/* 094 */
/* 095 */         if (!filter_value) {
/* 096 */           if (false) {
/* 097 */             filter_isNull = true;
/* 098 */           } else if (filter_value1.equals(((UTF8String) references[5]))) {
/* 099 */             filter_isNull = false;
/* 100 */             filter_value = true;
/* 101 */           }
/* 102 */         }
/* 103 */
/* 104 */         if (!filter_value) {
/* 105 */           if (false) {
/* 106 */             filter_isNull = true;
/* 107 */           } else if (filter_value1.equals(((UTF8String) references[6]))) {
/* 108 */             filter_isNull = false;
/* 109 */             filter_value = true;
/* 110 */           }
/* 111 */         }
/* 112 */
/* 113 */         if (!filter_value) {
/* 114 */           if (false) {
/* 115 */             filter_isNull = true;
/* 116 */           } else if (filter_value1.equals(((UTF8String) references[7]))) {
/* 117 */             filter_isNull = false;
/* 118 */             filter_value = true;
/* 119 */           }
/* 120 */         }
/* 121 */
/* 122 */         if (!filter_value) {
/* 123 */           if (false) {
/* 124 */             filter_isNull = true;
/* 125 */           } else if (filter_value1.equals(((UTF8String) references[8]))) {
/* 126 */             filter_isNull = false;
/* 127 */             filter_value = true;
/* 128 */           }
/* 129 */         }
/* 130 */
/* 131 */         if (!filter_value) {
/* 132 */           if (false) {
/* 133 */             filter_isNull = true;
/* 134 */           } else if (filter_value1.equals(((UTF8String) references[9]))) {
/* 135 */             filter_isNull = false;
/* 136 */             filter_value = true;
/* 137 */           }
/* 138 */         }
/* 139 */
/* 140 */         if (!filter_value) {
/* 141 */           if (false) {
/* 142 */             filter_isNull = true;
/* 143 */           } else if (filter_value1.equals(((UTF8String) references[10]))) {
/* 144 */             filter_isNull = false;
/* 145 */             filter_value = true;
/* 146 */           }
/* 147 */         }
/* 148 */
/* 149 */       }
/* 150 */       if (filter_isNull || !filter_value) continue;
/* 151 */
/* 152 */       filter_numOutputRows.add(1);
/* 153 */
/* 154 */       boolean project_isNull = inputadapter_isNull;
/* 155 */       UTF8String project_value = null;
/* 156 */
/* 157 */       if (!inputadapter_isNull) {
/* 158 */         if (inputadapter_value.isNullAt(0)) {
/* 159 */           project_isNull = true;
/* 160 */         } else {
/* 161 */           project_value = inputadapter_value.getUTF8String(0);
/* 162 */         }
/* 163 */
/* 164 */       }
/* 165 */       boolean project_isNull2 = inputadapter_isNull;
/* 166 */       UTF8String project_value2 = null;
/* 167 */
/* 168 */       if (!inputadapter_isNull) {
/* 169 */         if (inputadapter_value.isNullAt(1)) {
/* 170 */           project_isNull2 = true;
/* 171 */         } else {
/* 172 */           project_value2 = inputadapter_value.getUTF8String(1);
/* 173 */         }
/* 174 */
/* 175 */       }
/* 176 */
/* 177 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 178 */
/* 179 */       UnsafeRow agg_fastAggBuffer = null;
/* 180 */
/* 181 */       if (agg_fastAggBuffer == null) {
/* 182 */         // generate grouping key
/* 183 */         agg_holder.reset();
/* 184 */
/* 185 */         agg_rowWriter.zeroOutNullBytes();
/* 186 */
/* 187 */         if (project_isNull) {
/* 188 */           agg_rowWriter.setNullAt(0);
/* 189 */         } else {
/* 190 */           agg_rowWriter.write(0, project_value);
/* 191 */         }
/* 192 */
/* 193 */         if (project_isNull2) {
/* 194 */           agg_rowWriter.setNullAt(1);
/* 195 */         } else {
/* 196 */           agg_rowWriter.write(1, project_value2);
/* 197 */         }
/* 198 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 199 */         agg_value4 = 42;
/* 200 */
/* 201 */         if (!project_isNull) {
/* 202 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(project_value.getBaseObject(), project_value.getBaseOffset(), project_value.numBytes(), agg_value4);
/* 203 */         }
/* 204 */
/* 205 */         if (!project_isNull2) {
/* 206 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(project_value2.getBaseObject(), project_value2.getBaseOffset(), project_value2.numBytes(), agg_value4);
/* 207 */         }
/* 208 */         if (true) {
/* 209 */           // try to get the buffer from hash map
/* 210 */           agg_unsafeRowAggBuffer =
/* 211 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 212 */         }
/* 213 */         if (agg_unsafeRowAggBuffer == null) {
/* 214 */           if (agg_sorter == null) {
/* 215 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 216 */           } else {
/* 217 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 218 */           }
/* 219 */
/* 220 */           // the hash map had be spilled, it should have enough memory now,
/* 221 */           // try  to allocate buffer again.
/* 222 */           agg_unsafeRowAggBuffer =
/* 223 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 224 */           if (agg_unsafeRowAggBuffer == null) {
/* 225 */             // failed to allocate the first page
/* 226 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 227 */           }
/* 228 */         }
/* 229 */       }
/* 230 */
/* 231 */       if (agg_fastAggBuffer != null) {
/* 232 */         // update fast row
/* 233 */
/* 234 */       } else {
/* 235 */         // update unsafe row
/* 236 */
/* 237 */         // common sub-expressions
/* 238 */
/* 239 */         // evaluate aggregate function
/* 240 */
/* 241 */         // update unsafe row buffer
/* 242 */
/* 243 */       }
/* 244 */       if (shouldStop()) return;
/* 245 */     }
/* 246 */
/* 247 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 248 */   }
/* 249 */
/* 250 */   private void wholestagecodegen_init_1() {
/* 251 */     agg_result = new UnsafeRow(2);
/* 252 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 253 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 254 */
/* 255 */     agg_result1 = new UnsafeRow(2);
/* 256 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 257 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 258 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 259 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 260 */
/* 261 */   }
/* 262 */
/* 263 */   protected void processNext() throws java.io.IOException {
/* 264 */     if (!agg_initAgg) {
/* 265 */       agg_initAgg = true;
/* 266 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 267 */       agg_doAggregateWithKeys();
/* 268 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 269 */     }
/* 270 */
/* 271 */     // output the result
/* 272 */
/* 273 */     while (agg_mapIter.next()) {
/* 274 */       wholestagecodegen_numOutputRows.add(1);
/* 275 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 276 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 277 */
/* 278 */       boolean agg_isNull7 = agg_aggKey.isNullAt(0);
/* 279 */       UTF8String agg_value7 = agg_isNull7 ? null : (agg_aggKey.getUTF8String(0));
/* 280 */       boolean agg_isNull8 = agg_aggKey.isNullAt(1);
/* 281 */       UTF8String agg_value8 = agg_isNull8 ? null : (agg_aggKey.getUTF8String(1));
/* 282 */       agg_holder1.reset();
/* 283 */
/* 284 */       agg_rowWriter1.zeroOutNullBytes();
/* 285 */
/* 286 */       if (agg_isNull7) {
/* 287 */         agg_rowWriter1.setNullAt(0);
/* 288 */       } else {
/* 289 */         agg_rowWriter1.write(0, agg_value7);
/* 290 */       }
/* 291 */
/* 292 */       if (agg_isNull8) {
/* 293 */         agg_rowWriter1.setNullAt(1);
/* 294 */       } else {
/* 295 */         agg_rowWriter1.write(1, agg_value8);
/* 296 */       }
/* 297 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 298 */       append(agg_result1);
/* 299 */
/* 300 */       if (shouldStop()) return;
/* 301 */     }
/* 302 */
/* 303 */     agg_mapIter.close();
/* 304 */     if (agg_sorter == null) {
/* 305 */       agg_hashMap.free();
/* 306 */     }
/* 307 */   }
/* 308 */ }
