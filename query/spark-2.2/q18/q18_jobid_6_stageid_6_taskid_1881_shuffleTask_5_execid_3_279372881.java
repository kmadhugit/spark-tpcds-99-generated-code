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
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private UnsafeRow scan_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     wholestagecodegen_init_0();
/* 038 */     wholestagecodegen_init_1();
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */   private void wholestagecodegen_init_0() {
/* 043 */     scan_input = inputs[0];
/* 044 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     scan_scanTime1 = 0;
/* 047 */     scan_batch = null;
/* 048 */     scan_batchIdx = 0;
/* 049 */     scan_colInstance0 = null;
/* 050 */     scan_colInstance1 = null;
/* 051 */     scan_colInstance2 = null;
/* 052 */     scan_colInstance3 = null;
/* 053 */     scan_colInstance4 = null;
/* 054 */     scan_result = new UnsafeRow(5);
/* 055 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 056 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 057 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     filter_result = new UnsafeRow(5);
/* 059 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 060 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 061 */     project_result = new UnsafeRow(4);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void scan_nextBatch() throws java.io.IOException {
/* 067 */     long getBatchStart = System.nanoTime();
/* 068 */     if (scan_input.hasNext()) {
/* 069 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 070 */       scan_numOutputRows.add(scan_batch.numRows());
/* 071 */       scan_batchIdx = 0;
/* 072 */       scan_colInstance0 = scan_batch.column(0);
/* 073 */       scan_colInstance1 = scan_batch.column(1);
/* 074 */       scan_colInstance2 = scan_batch.column(2);
/* 075 */       scan_colInstance3 = scan_batch.column(3);
/* 076 */       scan_colInstance4 = scan_batch.column(4);
/* 077 */
/* 078 */     }
/* 079 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_1() {
/* 083 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   protected void processNext() throws java.io.IOException {
/* 088 */     if (scan_batch == null) {
/* 089 */       scan_nextBatch();
/* 090 */     }
/* 091 */     while (scan_batch != null) {
/* 092 */       int scan_numRows = scan_batch.numRows();
/* 093 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 094 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 095 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 096 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 097 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 098 */
/* 099 */         boolean filter_value = false;
/* 100 */         boolean filter_isNull = scan_isNull3;
/* 101 */         if (!filter_isNull) {
/* 102 */           if (!filter_value) {
/* 103 */             if (false) {
/* 104 */               filter_isNull = true;
/* 105 */             } else if (scan_value3 == 1) {
/* 106 */               filter_isNull = false;
/* 107 */               filter_value = true;
/* 108 */             }
/* 109 */           }
/* 110 */
/* 111 */           if (!filter_value) {
/* 112 */             if (false) {
/* 113 */               filter_isNull = true;
/* 114 */             } else if (scan_value3 == 6) {
/* 115 */               filter_isNull = false;
/* 116 */               filter_value = true;
/* 117 */             }
/* 118 */           }
/* 119 */
/* 120 */           if (!filter_value) {
/* 121 */             if (false) {
/* 122 */               filter_isNull = true;
/* 123 */             } else if (scan_value3 == 8) {
/* 124 */               filter_isNull = false;
/* 125 */               filter_value = true;
/* 126 */             }
/* 127 */           }
/* 128 */
/* 129 */           if (!filter_value) {
/* 130 */             if (false) {
/* 131 */               filter_isNull = true;
/* 132 */             } else if (scan_value3 == 9) {
/* 133 */               filter_isNull = false;
/* 134 */               filter_value = true;
/* 135 */             }
/* 136 */           }
/* 137 */
/* 138 */           if (!filter_value) {
/* 139 */             if (false) {
/* 140 */               filter_isNull = true;
/* 141 */             } else if (scan_value3 == 12) {
/* 142 */               filter_isNull = false;
/* 143 */               filter_value = true;
/* 144 */             }
/* 145 */           }
/* 146 */
/* 147 */           if (!filter_value) {
/* 148 */             if (false) {
/* 149 */               filter_isNull = true;
/* 150 */             } else if (scan_value3 == 2) {
/* 151 */               filter_isNull = false;
/* 152 */               filter_value = true;
/* 153 */             }
/* 154 */           }
/* 155 */
/* 156 */         }
/* 157 */         if (filter_isNull || !filter_value) continue;
/* 158 */
/* 159 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 160 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 161 */
/* 162 */         if (!(!(scan_isNull))) continue;
/* 163 */
/* 164 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 165 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 166 */
/* 167 */         if (!(!(scan_isNull1))) continue;
/* 168 */
/* 169 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 170 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 171 */
/* 172 */         if (!(!(scan_isNull2))) continue;
/* 173 */
/* 174 */         filter_numOutputRows.add(1);
/* 175 */
/* 176 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 177 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 178 */         project_rowWriter.zeroOutNullBytes();
/* 179 */
/* 180 */         project_rowWriter.write(0, scan_value);
/* 181 */
/* 182 */         project_rowWriter.write(1, scan_value1);
/* 183 */
/* 184 */         project_rowWriter.write(2, scan_value2);
/* 185 */
/* 186 */         if (scan_isNull4) {
/* 187 */           project_rowWriter.setNullAt(3);
/* 188 */         } else {
/* 189 */           project_rowWriter.write(3, scan_value4);
/* 190 */         }
/* 191 */         append(project_result);
/* 192 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 193 */       }
/* 194 */       scan_batchIdx = scan_numRows;
/* 195 */       scan_batch = null;
/* 196 */       scan_nextBatch();
/* 197 */     }
/* 198 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 199 */     scan_scanTime1 = 0;
/* 200 */   }
/* 201 */ }
