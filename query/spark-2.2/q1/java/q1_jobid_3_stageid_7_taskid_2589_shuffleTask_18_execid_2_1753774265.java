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
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value7;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
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
/* 048 */
/* 049 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 050 */
/* 051 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 053 */     inputadapter_input = inputs[0];
/* 054 */     agg_result = new UnsafeRow(1);
/* 055 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 056 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 057 */
/* 058 */     agg_result1 = new UnsafeRow(2);
/* 059 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 060 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 061 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 062 */     filter_result = new UnsafeRow(2);
/* 063 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 068 */     agg_hashMap = agg_plan.createHashMap();
/* 069 */
/* 070 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 071 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 072 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 073 */       long inputadapter_value = inputadapter_isNull ? -1L : (inputadapter_row.getLong(0));
/* 074 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 075 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 076 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 077 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 078 */
/* 079 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 080 */
/* 081 */       UnsafeRow agg_fastAggBuffer = null;
/* 082 */
/* 083 */       if (agg_fastAggBuffer == null) {
/* 084 */         // generate grouping key
/* 085 */         agg_rowWriter.zeroOutNullBytes();
/* 086 */
/* 087 */         if (inputadapter_isNull) {
/* 088 */           agg_rowWriter.setNullAt(0);
/* 089 */         } else {
/* 090 */           agg_rowWriter.write(0, inputadapter_value);
/* 091 */         }
/* 092 */         agg_value7 = 42;
/* 093 */
/* 094 */         if (!inputadapter_isNull) {
/* 095 */           agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value, agg_value7);
/* 096 */         }
/* 097 */         if (true) {
/* 098 */           // try to get the buffer from hash map
/* 099 */           agg_unsafeRowAggBuffer =
/* 100 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 101 */         }
/* 102 */         if (agg_unsafeRowAggBuffer == null) {
/* 103 */           if (agg_sorter == null) {
/* 104 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 105 */           } else {
/* 106 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 107 */           }
/* 108 */
/* 109 */           // the hash map had be spilled, it should have enough memory now,
/* 110 */           // try  to allocate buffer again.
/* 111 */           agg_unsafeRowAggBuffer =
/* 112 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 113 */           if (agg_unsafeRowAggBuffer == null) {
/* 114 */             // failed to allocate the first page
/* 115 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 116 */           }
/* 117 */         }
/* 118 */       }
/* 119 */
/* 120 */       if (agg_fastAggBuffer != null) {
/* 121 */         // update fast row
/* 122 */
/* 123 */       } else {
/* 124 */         // update unsafe row
/* 125 */
/* 126 */         // common sub-expressions
/* 127 */
/* 128 */         // evaluate aggregate function
/* 129 */         boolean agg_isNull7 = true;
/* 130 */         double agg_value9 = -1.0;
/* 131 */
/* 132 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 133 */         double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 134 */         if (!agg_isNull8) {
/* 135 */           if (!inputadapter_isNull1) {
/* 136 */             agg_isNull7 = false; // resultCode could change nullability.
/* 137 */             agg_value9 = agg_value10 + inputadapter_value1;
/* 138 */
/* 139 */           }
/* 140 */
/* 141 */         }
/* 142 */         boolean agg_isNull10 = true;
/* 143 */         long agg_value12 = -1L;
/* 144 */
/* 145 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 146 */         long agg_value13 = agg_isNull11 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 147 */         if (!agg_isNull11) {
/* 148 */           if (!inputadapter_isNull2) {
/* 149 */             agg_isNull10 = false; // resultCode could change nullability.
/* 150 */             agg_value12 = agg_value13 + inputadapter_value2;
/* 151 */
/* 152 */           }
/* 153 */
/* 154 */         }
/* 155 */         // update unsafe row buffer
/* 156 */         if (!agg_isNull7) {
/* 157 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 158 */         } else {
/* 159 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 160 */         }
/* 161 */
/* 162 */         if (!agg_isNull10) {
/* 163 */           agg_unsafeRowAggBuffer.setLong(1, agg_value12);
/* 164 */         } else {
/* 165 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 166 */         }
/* 167 */
/* 168 */       }
/* 169 */       if (shouldStop()) return;
/* 170 */     }
/* 171 */
/* 172 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 173 */   }
/* 174 */
/* 175 */   private void wholestagecodegen_init_1() {
/* 176 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 177 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 178 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 179 */
/* 180 */   }
/* 181 */
/* 182 */   protected void processNext() throws java.io.IOException {
/* 183 */     if (!agg_initAgg) {
/* 184 */       agg_initAgg = true;
/* 185 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 186 */       agg_doAggregateWithKeys();
/* 187 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 188 */     }
/* 189 */
/* 190 */     // output the result
/* 191 */
/* 192 */     while (agg_mapIter.next()) {
/* 193 */       wholestagecodegen_numOutputRows.add(1);
/* 194 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 195 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 196 */
/* 197 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 198 */       long agg_value15 = agg_isNull13 ? -1L : (agg_aggKey.getLong(0));
/* 199 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 200 */       double agg_value16 = agg_isNull14 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 201 */       boolean agg_isNull15 = agg_aggBuffer.isNullAt(1);
/* 202 */       long agg_value17 = agg_isNull15 ? -1L : (agg_aggBuffer.getLong(1));
/* 203 */       boolean agg_isNull18 = agg_isNull15;
/* 204 */       double agg_value20 = -1.0;
/* 205 */       if (!agg_isNull15) {
/* 206 */         agg_value20 = (double) agg_value17;
/* 207 */       }
/* 208 */       boolean agg_isNull16 = false;
/* 209 */       double agg_value18 = -1.0;
/* 210 */       if (agg_isNull18 || agg_value20 == 0) {
/* 211 */         agg_isNull16 = true;
/* 212 */       } else {
/* 213 */         if (agg_isNull14) {
/* 214 */           agg_isNull16 = true;
/* 215 */         } else {
/* 216 */           agg_value18 = (double)(agg_value16 / agg_value20);
/* 217 */         }
/* 218 */       }
/* 219 */
/* 220 */       boolean agg_isNull20 = true;
/* 221 */       double agg_value22 = -1.0;
/* 222 */
/* 223 */       if (!agg_isNull16) {
/* 224 */         agg_isNull20 = false; // resultCode could change nullability.
/* 225 */         agg_value22 = agg_value18 * 1.2D;
/* 226 */
/* 227 */       }
/* 228 */
/* 229 */       if (!(!(agg_isNull20))) continue;
/* 230 */
/* 231 */       filter_numOutputRows.add(1);
/* 232 */
/* 233 */       filter_rowWriter.zeroOutNullBytes();
/* 234 */
/* 235 */       filter_rowWriter.write(0, agg_value22);
/* 236 */
/* 237 */       if (agg_isNull13) {
/* 238 */         filter_rowWriter.setNullAt(1);
/* 239 */       } else {
/* 240 */         filter_rowWriter.write(1, agg_value15);
/* 241 */       }
/* 242 */       append(filter_result);
/* 243 */
/* 244 */       if (shouldStop()) return;
/* 245 */     }
/* 246 */
/* 247 */     agg_mapIter.close();
/* 248 */     if (agg_sorter == null) {
/* 249 */       agg_hashMap.free();
/* 250 */     }
/* 251 */   }
/* 252 */ }
