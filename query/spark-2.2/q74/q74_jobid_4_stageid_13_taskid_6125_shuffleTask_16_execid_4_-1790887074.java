/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value10;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(4);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 055 */
/* 056 */     agg_result1 = new UnsafeRow(2);
/* 057 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 058 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 059 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     filter_result = new UnsafeRow(2);
/* 061 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 066 */     agg_hashMap = agg_plan.createHashMap();
/* 067 */
/* 068 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 069 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 070 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 071 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 072 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 073 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 074 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 075 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 076 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 077 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 078 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 079 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 080 */
/* 081 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 082 */
/* 083 */       UnsafeRow agg_fastAggBuffer = null;
/* 084 */
/* 085 */       if (agg_fastAggBuffer == null) {
/* 086 */         // generate grouping key
/* 087 */         agg_holder.reset();
/* 088 */
/* 089 */         agg_rowWriter.zeroOutNullBytes();
/* 090 */
/* 091 */         if (inputadapter_isNull) {
/* 092 */           agg_rowWriter.setNullAt(0);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(0, inputadapter_value);
/* 095 */         }
/* 096 */
/* 097 */         if (inputadapter_isNull1) {
/* 098 */           agg_rowWriter.setNullAt(1);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(1, inputadapter_value1);
/* 101 */         }
/* 102 */
/* 103 */         if (inputadapter_isNull2) {
/* 104 */           agg_rowWriter.setNullAt(2);
/* 105 */         } else {
/* 106 */           agg_rowWriter.write(2, inputadapter_value2);
/* 107 */         }
/* 108 */
/* 109 */         if (inputadapter_isNull3) {
/* 110 */           agg_rowWriter.setNullAt(3);
/* 111 */         } else {
/* 112 */           agg_rowWriter.write(3, inputadapter_value3);
/* 113 */         }
/* 114 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 115 */         agg_value10 = 42;
/* 116 */
/* 117 */         if (!inputadapter_isNull) {
/* 118 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value10);
/* 119 */         }
/* 120 */
/* 121 */         if (!inputadapter_isNull1) {
/* 122 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value10);
/* 123 */         }
/* 124 */
/* 125 */         if (!inputadapter_isNull2) {
/* 126 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value10);
/* 127 */         }
/* 128 */
/* 129 */         if (!inputadapter_isNull3) {
/* 130 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value10);
/* 131 */         }
/* 132 */         if (true) {
/* 133 */           // try to get the buffer from hash map
/* 134 */           agg_unsafeRowAggBuffer =
/* 135 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 136 */         }
/* 137 */         if (agg_unsafeRowAggBuffer == null) {
/* 138 */           if (agg_sorter == null) {
/* 139 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 140 */           } else {
/* 141 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 142 */           }
/* 143 */
/* 144 */           // the hash map had be spilled, it should have enough memory now,
/* 145 */           // try  to allocate buffer again.
/* 146 */           agg_unsafeRowAggBuffer =
/* 147 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 148 */           if (agg_unsafeRowAggBuffer == null) {
/* 149 */             // failed to allocate the first page
/* 150 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 151 */           }
/* 152 */         }
/* 153 */       }
/* 154 */
/* 155 */       if (agg_fastAggBuffer != null) {
/* 156 */         // update fast row
/* 157 */
/* 158 */       } else {
/* 159 */         // update unsafe row
/* 160 */
/* 161 */         // common sub-expressions
/* 162 */
/* 163 */         // evaluate aggregate function
/* 164 */         boolean agg_isNull15 = true;
/* 165 */         double agg_value16 = -1.0;
/* 166 */
/* 167 */         boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 168 */         double agg_value18 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 169 */         boolean agg_isNull16 = agg_isNull17;
/* 170 */         double agg_value17 = agg_value18;
/* 171 */         if (agg_isNull16) {
/* 172 */           boolean agg_isNull18 = false;
/* 173 */           double agg_value19 = -1.0;
/* 174 */           if (!false) {
/* 175 */             agg_value19 = (double) 0;
/* 176 */           }
/* 177 */           if (!agg_isNull18) {
/* 178 */             agg_isNull16 = false;
/* 179 */             agg_value17 = agg_value19;
/* 180 */           }
/* 181 */         }
/* 182 */
/* 183 */         if (!inputadapter_isNull4) {
/* 184 */           agg_isNull15 = false; // resultCode could change nullability.
/* 185 */           agg_value16 = agg_value17 + inputadapter_value4;
/* 186 */
/* 187 */         }
/* 188 */         boolean agg_isNull14 = agg_isNull15;
/* 189 */         double agg_value15 = agg_value16;
/* 190 */         if (agg_isNull14) {
/* 191 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 192 */           double agg_value22 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 193 */           if (!agg_isNull21) {
/* 194 */             agg_isNull14 = false;
/* 195 */             agg_value15 = agg_value22;
/* 196 */           }
/* 197 */         }
/* 198 */         // update unsafe row buffer
/* 199 */         if (!agg_isNull14) {
/* 200 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 201 */         } else {
/* 202 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 203 */         }
/* 204 */
/* 205 */       }
/* 206 */       if (shouldStop()) return;
/* 207 */     }
/* 208 */
/* 209 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 210 */   }
/* 211 */
/* 212 */   private void wholestagecodegen_init_1() {
/* 213 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 214 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 215 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 216 */
/* 217 */   }
/* 218 */
/* 219 */   protected void processNext() throws java.io.IOException {
/* 220 */     if (!agg_initAgg) {
/* 221 */       agg_initAgg = true;
/* 222 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 223 */       agg_doAggregateWithKeys();
/* 224 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 225 */     }
/* 226 */
/* 227 */     // output the result
/* 228 */
/* 229 */     while (agg_mapIter.next()) {
/* 230 */       wholestagecodegen_numOutputRows.add(1);
/* 231 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 232 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 233 */
/* 234 */       boolean agg_isNull22 = agg_aggKey.isNullAt(0);
/* 235 */       UTF8String agg_value23 = agg_isNull22 ? null : (agg_aggKey.getUTF8String(0));
/* 236 */       boolean agg_isNull23 = agg_aggKey.isNullAt(1);
/* 237 */       UTF8String agg_value24 = agg_isNull23 ? null : (agg_aggKey.getUTF8String(1));
/* 238 */       boolean agg_isNull24 = agg_aggKey.isNullAt(2);
/* 239 */       UTF8String agg_value25 = agg_isNull24 ? null : (agg_aggKey.getUTF8String(2));
/* 240 */       boolean agg_isNull25 = agg_aggKey.isNullAt(3);
/* 241 */       int agg_value26 = agg_isNull25 ? -1 : (agg_aggKey.getInt(3));
/* 242 */       boolean agg_isNull26 = agg_aggBuffer.isNullAt(0);
/* 243 */       double agg_value27 = agg_isNull26 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 244 */
/* 245 */       if (!(!(agg_isNull26))) continue;
/* 246 */
/* 247 */       boolean filter_isNull2 = false;
/* 248 */
/* 249 */       boolean filter_value2 = false;
/* 250 */       filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value27, 0.0D) > 0;
/* 251 */       if (!filter_value2) continue;
/* 252 */
/* 253 */       filter_numOutputRows.add(1);
/* 254 */
/* 255 */       filter_holder.reset();
/* 256 */
/* 257 */       filter_rowWriter.zeroOutNullBytes();
/* 258 */
/* 259 */       if (agg_isNull22) {
/* 260 */         filter_rowWriter.setNullAt(0);
/* 261 */       } else {
/* 262 */         filter_rowWriter.write(0, agg_value23);
/* 263 */       }
/* 264 */
/* 265 */       filter_rowWriter.write(1, agg_value27);
/* 266 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 267 */       append(filter_result);
/* 268 */
/* 269 */       if (shouldStop()) return;
/* 270 */     }
/* 271 */
/* 272 */     agg_mapIter.close();
/* 273 */     if (agg_sorter == null) {
/* 274 */       agg_hashMap.free();
/* 275 */     }
/* 276 */   }
/* 277 */ }
