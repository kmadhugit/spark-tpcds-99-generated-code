/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     wholestagecodegen_init_0();
/* 036 */     wholestagecodegen_init_1();
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void wholestagecodegen_init_0() {
/* 041 */     scan_input = inputs[0];
/* 042 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     scan_scanTime1 = 0;
/* 045 */     scan_batch = null;
/* 046 */     scan_batchIdx = 0;
/* 047 */     scan_colInstance0 = null;
/* 048 */     scan_colInstance1 = null;
/* 049 */     scan_colInstance2 = null;
/* 050 */     scan_result = new UnsafeRow(3);
/* 051 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 64);
/* 052 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     filter_result = new UnsafeRow(3);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 057 */     project_result = new UnsafeRow(3);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void scan_nextBatch() throws java.io.IOException {
/* 063 */     long getBatchStart = System.nanoTime();
/* 064 */     if (scan_input.hasNext()) {
/* 065 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 066 */       scan_numOutputRows.add(scan_batch.numRows());
/* 067 */       scan_batchIdx = 0;
/* 068 */       scan_colInstance0 = scan_batch.column(0);
/* 069 */       scan_colInstance1 = scan_batch.column(1);
/* 070 */       scan_colInstance2 = scan_batch.column(2);
/* 071 */
/* 072 */     }
/* 073 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_1() {
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (scan_batch == null) {
/* 083 */       scan_nextBatch();
/* 084 */     }
/* 085 */     while (scan_batch != null) {
/* 086 */       int scan_numRows = scan_batch.numRows();
/* 087 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 088 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 089 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 090 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 091 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 092 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 093 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 094 */
/* 095 */         boolean filter_isNull2 = true;
/* 096 */         boolean filter_value2 = false;
/* 097 */
/* 098 */         if (!scan_isNull1) {
/* 099 */           filter_isNull2 = false; // resultCode could change nullability.
/* 100 */           filter_value2 = scan_value1.equals(((UTF8String) references[3]));
/* 101 */
/* 102 */         }
/* 103 */         boolean filter_isNull1 = false;
/* 104 */         boolean filter_value1 = false;
/* 105 */
/* 106 */         if (!filter_isNull2 && !filter_value2) {
/* 107 */         } else {
/* 108 */           boolean filter_isNull5 = true;
/* 109 */           boolean filter_value5 = false;
/* 110 */
/* 111 */           if (!scan_isNull2) {
/* 112 */             filter_isNull5 = false; // resultCode could change nullability.
/* 113 */             filter_value5 = scan_value2.equals(((UTF8String) references[4]));
/* 114 */
/* 115 */           }
/* 116 */           if (!filter_isNull5 && !filter_value5) {
/* 117 */           } else if (!filter_isNull2 && !filter_isNull5) {
/* 118 */             filter_value1 = true;
/* 119 */           } else {
/* 120 */             filter_isNull1 = true;
/* 121 */           }
/* 122 */         }
/* 123 */         boolean filter_isNull = false;
/* 124 */         boolean filter_value = true;
/* 125 */
/* 126 */         if (!filter_isNull1 && filter_value1) {
/* 127 */         } else {
/* 128 */           boolean filter_isNull9 = true;
/* 129 */           boolean filter_value9 = false;
/* 130 */
/* 131 */           if (!scan_isNull1) {
/* 132 */             filter_isNull9 = false; // resultCode could change nullability.
/* 133 */             filter_value9 = scan_value1.equals(((UTF8String) references[5]));
/* 134 */
/* 135 */           }
/* 136 */           boolean filter_isNull8 = false;
/* 137 */           boolean filter_value8 = false;
/* 138 */
/* 139 */           if (!filter_isNull9 && !filter_value9) {
/* 140 */           } else {
/* 141 */             boolean filter_isNull12 = true;
/* 142 */             boolean filter_value12 = false;
/* 143 */
/* 144 */             if (!scan_isNull2) {
/* 145 */               filter_isNull12 = false; // resultCode could change nullability.
/* 146 */               filter_value12 = scan_value2.equals(((UTF8String) references[6]));
/* 147 */
/* 148 */             }
/* 149 */             if (!filter_isNull12 && !filter_value12) {
/* 150 */             } else if (!filter_isNull9 && !filter_isNull12) {
/* 151 */               filter_value8 = true;
/* 152 */             } else {
/* 153 */               filter_isNull8 = true;
/* 154 */             }
/* 155 */           }
/* 156 */           if (!filter_isNull8 && filter_value8) {
/* 157 */           } else if (!filter_isNull1 && !filter_isNull8) {
/* 158 */             filter_value = false;
/* 159 */           } else {
/* 160 */             filter_isNull = true;
/* 161 */           }
/* 162 */         }
/* 163 */         if (filter_isNull || !filter_value) continue;
/* 164 */
/* 165 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 166 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 167 */
/* 168 */         if (!(!(scan_isNull))) continue;
/* 169 */
/* 170 */         filter_numOutputRows.add(1);
/* 171 */
/* 172 */         project_holder.reset();
/* 173 */
/* 174 */         project_rowWriter.zeroOutNullBytes();
/* 175 */
/* 176 */         project_rowWriter.write(0, scan_value);
/* 177 */
/* 178 */         if (scan_isNull1) {
/* 179 */           project_rowWriter.setNullAt(1);
/* 180 */         } else {
/* 181 */           project_rowWriter.write(1, scan_value1);
/* 182 */         }
/* 183 */
/* 184 */         if (scan_isNull2) {
/* 185 */           project_rowWriter.setNullAt(2);
/* 186 */         } else {
/* 187 */           project_rowWriter.write(2, scan_value2);
/* 188 */         }
/* 189 */         project_result.setTotalSize(project_holder.totalSize());
/* 190 */         append(project_result);
/* 191 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 192 */       }
/* 193 */       scan_batchIdx = scan_numRows;
/* 194 */       scan_batch = null;
/* 195 */       scan_nextBatch();
/* 196 */     }
/* 197 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 198 */     scan_scanTime1 = 0;
/* 199 */   }
/* 200 */ }
